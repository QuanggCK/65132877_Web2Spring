package thigk2.phamminhquang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import thigk2.phamminhquang.models.TinTuc;
import thigk2.phamminhquang.services.TinTucService;
import thigk2.phamminhquang.services.LoaiTinTucService;

@Controller
public class AdminController {

    @Autowired
    private TinTucService tinTucService;

    @Autowired
    private LoaiTinTucService loaiTinTucService;

    // CHỈ GIỮ LẠI 1 HÀM NÀY - ĐÃ GỘP CẢ CHECK LOGIN VÀ ĐỔ DỮ LIỆU
    @GetMapping("/admin/tintuc")
    public String adminList(ModelMap m, HttpSession session) {
        // 1. Kiểm tra session xem đã đăng nhập chưa
        if (session.getAttribute("admin") == null) {
            return "redirect:/login"; 
        }
        
        // 2. Nếu đã đăng nhập, đổ dữ liệu ra bảng quản lý
        m.addAttribute("dsTinTuc", tinTucService.getAllTinTuc());
        m.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        
        // Dùng cho form thêm mới trong Modal
        m.addAttribute("newTinTuc", new TinTuc()); 
        
        return "admin_tintuc";
    }

    @PostMapping("/admin/tintuc/save")
    public String save(@ModelAttribute("tintuc") TinTuc tinTuc) {
        tinTucService.saveTinTuc(tinTuc);
        return "redirect:/admin/tintuc";
    }

    @GetMapping("/admin/tintuc/edit/{id}")
    public String editPage(@PathVariable("id") int id, ModelMap m, HttpSession session) {
        // Nên check login cả ở đây để bảo mật tuyệt đối
        if (session.getAttribute("admin") == null) return "redirect:/login";

        m.addAttribute("tintuc", tinTucService.getChiTietTin(id));
        m.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "updateTinTuc";
    }

    @GetMapping("/admin/tintuc/delete/{id}")
    public String delete(@PathVariable("id") int id, HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/login";

        tinTucService.deleteTinTuc(id);
        return "redirect:/admin/tintuc";
    }
}