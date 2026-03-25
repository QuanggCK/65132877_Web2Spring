package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "HomePage";
	}
	
	// Test User thuong
	@GetMapping("/products")
	public String indexP() {
		return "sanpham";
	}
	
	// Test Admin
	@GetMapping("/admincp")
	public String adminCP() {
		return "IndexAdmin";
	}
	
	// Test other
	@GetMapping("/hello/")
	public String hi() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
}