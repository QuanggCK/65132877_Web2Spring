package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	// Danh sách Page, Post
	ArrayList<Page> dsTrang = new ArrayList<Page>();
	ArrayList<Post> dsPost = new ArrayList<Post>();
	
	public HomeController() {
		// Page
		dsTrang.add(new Page ("001", "CaiJDo", "cjd", "nothatsula1caijday", "001") );
		dsTrang.add(new Page ("002", "CaiJDo2", "cjd2", "nothatsula2caijday", "002"));
		dsTrang.add(new Page ("003", "CaiJDo3", "cjd3", "nothatsula3caijday", "003"));
		// Post
		dsPost.add( new Post("01","PhaDaoDiGioi1","Makoto clutch con Gryphon","018","Shinja1"));
		dsPost.add( new Post("02","PhaDaoDiGioi2","Makoto gank 2 con quái biển cùng Dũng Sĩ Ánh Sáng ","019","Shinja2"));
		dsPost.add( new Post("03","PhaDaoDiGioi3","Makoto cứu thủy công chúa Sofia","020","Shinja3"));
	}
	
	@GetMapping("/page/all") 
	public String getTatCaPage(ModelMap m) {
		m.addAttribute("lstPages",dsTrang);
		return "allpage";
	}
	
    @GetMapping("/page/new")
    public String showAddPageForm(ModelMap m) {
        m.addAttribute("page", new Page()); 
        return "newpage"; 
    }

    @PostMapping("/page/new")
    public String saveNewPage(@ModelAttribute("page") Page newPage) {
        dsTrang.add(newPage);
        return "redirect:/page/all"; 
    }


    @GetMapping("/page/view/{id}")
    public String viewPage(@PathVariable("id") String id, ModelMap m) {
        Page foundPage = null;
        for (Page p : dsTrang) {
            if (p.getId().equals(id)) { 
                foundPage = p;
                break;
            }
        }
        

        if (foundPage != null) {
            m.addAttribute("pageDetail", foundPage);
            return "viewpage"; 
        } else {
            return "redirect:/page/all"; 
        }
    }

    @GetMapping("/page/delete/{id}")
    public String deletePage(@PathVariable("id") String id) {
        dsTrang.removeIf(p -> p.getId().equals(id));
        return "redirect:/page/all"; 
    }
	
	
	
	
}