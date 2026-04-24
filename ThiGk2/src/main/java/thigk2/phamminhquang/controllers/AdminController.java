package thigk2.phamminhquang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import thigk2.phamminhquang.models.TinTuc;
import thigk2.phamminhquang.services.TinTucService;
import thigk2.phamminhquang.services.LoaiTinTucService;

@Controller
public class AdminController {

    @Autowired
    private TinTucService tinTucService;

    @Autowired
    private LoaiTinTucService loaiTinTucService;

    @GetMapping("/admin/tintuc")
    public String adminList(ModelMap m) {
        m.addAttribute("dsTinTuc", tinTucService.getAllTinTuc());
        m.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        m.addAttribute("newTinTuc", new TinTuc()); 
        return "admin_tintuc";
    }

 
    @PostMapping("/admin/tintuc/save")
    public String save(@ModelAttribute("tintuc") TinTuc tinTuc) {
        tinTucService.saveTinTuc(tinTuc);
        return "redirect:/admin/tintuc";
    }


    @GetMapping("/admin/tintuc/edit/{id}")
    public String editPage(@PathVariable("id") int id, ModelMap m) {
        m.addAttribute("tintuc", tinTucService.getChiTietTin(id));
        m.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "updateTinTuc";
    }


    @GetMapping("/admin/tintuc/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        tinTucService.deleteTinTuc(id);
        return "redirect:/admin/tintuc";
    }
}