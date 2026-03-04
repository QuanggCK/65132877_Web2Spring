package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DemoController {
	// Ví dụ truyền dữ liệu sang View index
	@GetMapping("/vd")
	public String getTest1 (ModelMap m) {
		m.addAttribute("tb","Du lieu nay den tu Controller");
		
		return "index";
		
	}
	
	@GetMapping("/vd2")
	// ?ten=QuanggCK&mk=quanggck
	public String getTest2(HttpServletRequest thamso, ModelMap m) {
		String tenNhapDuoc = thamso.getParameter("ten");
		String mkNhapDuoc = thamso.getParameter("mk");
		m.addAttribute("name", tenNhapDuoc);
		m.addAttribute("pass", mkNhapDuoc);
		
		return "index2";
	}
	
	@GetMapping("/vd3")
	// ?ten=QuanggCK&mk=quanggck
	public String getTest3(@RequestParam("ten") String tenP, @RequestParam("mkh") String matK, ModelMap m) {
		m.addAttribute("name", tenP);
		m.addAttribute("pass", matK);
		
		return "index2";
	}
	
	//=============================================================
	@GetMapping("/login")
	public String dangNhap() {
		return "login";
		// Ta tao trang lgin.html
		// action =vd4
		// method = post
	}
	
	
	// Lấy dữ liệu từ form
	@PostMapping("/form")
	public String getForm(ModelMap m, HttpServletRequest thamso) {
		String tenNhapDuoc = thamso.getParameter("uname");
		String mkNhapDuoc = thamso.getParameter("upass");
		m.addAttribute("name",tenNhapDuoc);
		m.addAttribute("pass", mkNhapDuoc);
		
		
		return "index4";
	}
}
