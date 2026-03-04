package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    // Xây dựng action
    // mapping URL
    @GetMapping("/")
    public String trangChu() {
        return "index"; 
    }
    @GetMapping("/about")
    public String GioiThieu() {
    	return "about";
    }
    
}