package thigk2.phamminhquang.controllers;

import thigk2.phamminhquang.models.SanPham;
import thigk2.phamminhquang.service.SanPhamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
public class MyRestController {

    private final SanPhamService sanPhamService;
    public MyRestController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }


    @GetMapping
    public List<SanPham> layTatCa() {
        return sanPhamService.getAllSanPham();
    }


    @GetMapping("/{id}")
    public SanPham layTheoId(@PathVariable("id") Integer id) {
        return sanPhamService.getSanPhamById(id);
    }
}