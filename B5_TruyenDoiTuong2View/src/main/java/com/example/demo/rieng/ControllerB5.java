package com.example.demo.rieng;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerB5 {

    @GetMapping("/bai5")
    public String truyenDoiTuong(ModelMap model) {
        SinhVien sv1 = new SinhVien("65132877", "QuanggCK", 9.5);
        model.addAttribute("sv", sv1);
        return "thongtin_sv";
    }
}