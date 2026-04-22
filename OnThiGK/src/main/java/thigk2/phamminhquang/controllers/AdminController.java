package thigk2.phamminhquang.controllers;

import thigk2.phamminhquang.models.SanPham;
import thigk2.phamminhquang.service.LoaiSanPhamService;
import thigk2.phamminhquang.service.SanPhamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SanPhamService sanPhamService;
    private final LoaiSanPhamService loaiSanPhamService;

    // Constructor Injection
    public AdminController(SanPhamService sanPhamService, LoaiSanPhamService loaiSanPhamService) {
        this.sanPhamService = sanPhamService;
        this.loaiSanPhamService = loaiSanPhamService;
    }


    @GetMapping("")
    public String adminIndex(Model model) {
        model.addAttribute("danhSachSP", sanPhamService.getAllSanPham());
        return "admin/index"; 
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sanpham", new SanPham());
        model.addAttribute("danhSachLoai", loaiSanPhamService.getAllLoai());
        return "admin/add-edit";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sanpham", sanPhamService.getSanPhamById(id));
        model.addAttribute("danhSachLoai", loaiSanPhamService.getAllLoai());
        return "admin/add-edit";
    }


    @PostMapping("/save")
    public String saveSanPham(@ModelAttribute("sanpham") SanPham sp) {
        sanPhamService.saveSanPham(sp);
        return "redirect:/admin";
    }


    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable("id") Integer id) {
        sanPhamService.deleteSanPham(id);
        return "redirect:/admin";
    }
    

        @GetMapping("")
        public String adminIndex(HttpSession session, Model model) {

            if (session.getAttribute("user") == null) {
                return "redirect:/login"; 
            }
            model.addAttribute("danhSachSP", sanPhamService.getAllSanPham());
            return "admin/index";
        }

}
