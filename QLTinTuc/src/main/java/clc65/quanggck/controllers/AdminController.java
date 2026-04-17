package clc65.quanggck.controllers;

import clc65.quanggck.models.tintuc;
import clc65.quanggck.service.TinTucService;
import clc65.quanggck.service.LoaiTinTucService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final TinTucService tinTucService;
    private final LoaiTinTucService loaiTinTucService;

    public AdminController(TinTucService tinTucService, LoaiTinTucService loaiTinTucService) {
        this.tinTucService = tinTucService;
        this.loaiTinTucService = loaiTinTucService;
    }

    @GetMapping("")
    public String adminIndex(Model model) {
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        return "admin/index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tin", new tintuc());
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "admin/add-edit";
    }

    @PostMapping("/save")
    public String saveTin(@ModelAttribute("tin") tintuc tin, Model model) {
        tinTucService.saveTinTuc(tin); 
        
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        return "admin/index"; 
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "admin/add-edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteTin(@PathVariable Integer id, Model model) {
        tinTucService.deleteTinTuc(id); 
        
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        return "admin/index"; 
    }
}