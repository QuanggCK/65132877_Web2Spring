package clc65.quanggck.controllers;

import clc65.quanggck.service.TinTucService;
import clc65.quanggck.service.LoaiTinTucService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final TinTucService tinTucService;
    private final LoaiTinTucService loaiTinTucService;

    public HomeController(TinTucService tinTucService, LoaiTinTucService loaiTinTucService) {
        this.tinTucService = tinTucService;
        this.loaiTinTucService = loaiTinTucService;
    }

    // Trang chủ: Hiển thị tất cả tin tức
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "index"; // Trả về file index.html trong folder templates
    }

    // Xem chi tiết một bài tin
    @GetMapping("/tin-tuc/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        return "detail"; 
    }
}