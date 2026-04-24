package thigk2.phamminhquang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thigk2.phamminhquang.services.TinTucService;
import thigk2.phamminhquang.services.LoaiTinTucService;

@Controller
public class HomeController {

    @Autowired
    private TinTucService tinTucService;

    @Autowired
    private LoaiTinTucService loaiTinTucService;

    @GetMapping("/home/tintuc")
    public String index(ModelMap m) {
        m.addAttribute("dsTinTuc", tinTucService.getAllTinTuc());
        m.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "home_tintuc"; 
    }

    @GetMapping("/home/tintuc/loai/{id}")
    public String filterByLoai(@PathVariable("id") int id, ModelMap m) {
        m.addAttribute("dsTinTuc", tinTucService.getTinTucByLoai(id));
        m.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        m.addAttribute("loaiDangChon", loaiTinTucService.getLoaiById(id));
        return "home_tintuc";
    }

    @GetMapping("/home/tintuc/detail/{id}")
    public String detail(@PathVariable("id") int id, ModelMap m) {
        m.addAttribute("tin", tinTucService.getChiTietTin(id));
        return "detail_tintuc";
    }
}