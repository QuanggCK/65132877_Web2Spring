package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String HomePage(ModelMap m) {
		String mssv = "65132877"; 
        String hoTen = "Phạm Minh Quang";
        int namSinh = 2005;
        String lop = "65.CNTT-CLC";
        
        m.addAttribute("ms",mssv);
        m.addAttribute("ten",hoTen);
        m.addAttribute("nam",namSinh);
       m.addAttribute("lp",lop);
		return "index";
	}
	
}
