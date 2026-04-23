package thigk2.phamminhquang.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thigk2.phamminhquang.services.*;
@Controller
public class HomeControllers {
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/home")
	public String getAll (ModelMap m) {
		m.addAttribute("dsSanPham", sanPhamService.getAllSanPham());
		return "home";
	}
	
	@GetMapping("/home/{id}")
	public String showDetail(@PathVariable("id") int id, ModelMap m) {
		m.addAttribute("page", sanPhamService.getSanPham(id));
		return "detail";
	}
}