package thigk2.phamminhquang.controllers;

import thigk2.phamminhquang.service.LoaiSanPhamService;
import thigk2.phamminhquang.service.SanPhamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final SanPhamService sanPhamService;
    private final LoaiSanPhamService loaiSanPhamService;

    public HomeController(SanPhamService sanPhamService, LoaiSanPhamService loaiSanPhamService) {
        this.sanPhamService = sanPhamService;
        this.loaiSanPhamService = loaiSanPhamService;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("danhSachSP", sanPhamService.getAllSanPham());
        model.addAttribute("danhSachLoai", loaiSanPhamService.getAllLoai());
        return "index";
    }


    @GetMapping("/san-pham/{id}")
    public String viewDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sp", sanPhamService.getSanPhamById(id));
        return "detail"; 
    }
    
    @GetMapping("/login")
    public String trangDangNhap() {
        return "login"; 
    }

    @PostMapping("/login")
    public String xuLyDangNhap(@RequestParam("username") String username, 
                               @RequestParam("password") String password, 
                               HttpSession session, 
                               Model model) {
        
        if ("admin".equals(username) && "123".equals(password)) {
            session.setAttribute("user", "admin"); 
            return "redirect:/admin"; 
        } else {
            model.addAttribute("error", true); 
            return "login"; 
        }
    }
}