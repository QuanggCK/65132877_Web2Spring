package clc65.quanggck.controllers;

import clc65.quanggck.models.tintuc;
import clc65.quanggck.service.TinTucService;
import clc65.quanggck.service.LoaiTinTucService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin") // Tất cả link trong này đều bắt đầu bằng /admin
public class AdminController {

    private final TinTucService tinTucService;
    private final LoaiTinTucService loaiTinTucService;

    public AdminController(TinTucService tinTucService, LoaiTinTucService loaiTinTucService) {
        this.tinTucService = tinTucService;
        this.loaiTinTucService = loaiTinTucService;
    }

    // 1. Danh sách tin tức trong trang quản trị
    @GetMapping("")
    public String adminIndex(Model model) {
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        return "admin/index";
    }

    // 2. Hiện form thêm tin mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tin", new tintuc()); // Tạo đối tượng rỗng cho form
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "admin/add-edit";
    }

    // 3. Xử lý lưu tin (Cả Thêm mới và Cập nhật)
    @PostMapping("/save")
    public String saveTin(@ModelAttribute("tin") tintuc tin) {
        tinTucService.saveTinTuc(tin);
        return "redirect:/admin"; // Lưu xong quay về trang danh sách
    }

    // 4. Hiện form sửa tin
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "admin/add-edit";
    }

    // 5. Xử lý xóa tin
    @GetMapping("/delete/{id}")
    public String deleteTin(@PathVariable Integer id) {
        tinTucService.deleteTinTuc(id);
        return "redirect:/admin";
    }
}