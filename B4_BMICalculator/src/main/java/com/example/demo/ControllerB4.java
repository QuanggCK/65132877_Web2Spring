package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerB4 {


    @GetMapping("/bai4")
    public String hienThiFormBMI() {
        return "form_bmi";
    }

    @PostMapping("/tinh-bmi")
    public String xuLyBMI(
            // Dùng kiểu double để nhận số thập phân (như 1.75m, 65.5kg)
            @RequestParam("chieuCao") double chieuCao,
            @RequestParam("canNang") double canNang,
            ModelMap model
    ) {

        double bmi = canNang / (chieuCao * chieuCao);
        
        String ketLuan = "";

        if (bmi < 18.5) {
            ketLuan = "Gầy (Thiếu cân)";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            ketLuan = "Bình thường (Chuẩn body)";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            ketLuan = "Thừa cân";
        } else {
            ketLuan = "Béo phì";
        }

        String bmiLamTron = String.format("%.1f", bmi);

        model.addAttribute("diemBMI", bmiLamTron);
        model.addAttribute("phanLoai", ketLuan);

        return "ketqua_bmi";
    }
}