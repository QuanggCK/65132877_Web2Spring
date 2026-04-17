package clc65.quanggck.controllers;

import clc65.quanggck.service.TinTucService;
import clc65.quanggck.service.LoaiTinTucService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final TinTucService tinTucService;
    private final LoaiTinTucService loaiTinTucService;

    public HomeController(TinTucService tinTucService, LoaiTinTucService loaiTinTucService) {
        this.tinTucService = tinTucService;
        this.loaiTinTucService = loaiTinTucService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "index"; 
    }

    @GetMapping("/loai/{id}")
    public String tinTucTheoLoai(@PathVariable Integer id, Model model) {
        model.addAttribute("danhSachTin", tinTucService.getTinTucById(id)); 
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        
        return "index"; 
    }

    @GetMapping("/tin-tuc/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        return "detail"; 
    }
    
    @PostMapping("/login")
    public String xuLyDangNhap(@RequestParam("username") String username, 
                               @RequestParam("password") String password, 
                               Model model) {
        if ("admin".equals(username) && "123".equals(password)) {
            return "redirect:/admin"; 
        } else {
            model.addAttribute("error", true); 
            return "login"; 
        }
    }

}