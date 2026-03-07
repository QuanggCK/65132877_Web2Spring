package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
	@GetMapping("/ttsv")
	public String thongTinSV (ModelMap m) {
		String mssv = "65132877"; 
        String hoTen = "QuanggCK";
        int namSinh = 2005;
        String gioiTinh = "Nam";
        
        m.addAttribute("ms",mssv);
        m.addAttribute("ten",hoTen);
        m.addAttribute("nam",namSinh);
       m.addAttribute("gt",gioiTinh);
       
       return "ttsv";

	}
	
	
}
