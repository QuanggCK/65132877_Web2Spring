package thigk2.phamminhquang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thigk2.phamminhquang.models.TinTuc;
import thigk2.phamminhquang.models.LoaiTinTuc;
import thigk2.phamminhquang.services.TinTucService;
import thigk2.phamminhquang.services.LoaiTinTucService;

import java.util.List;

@RestController
public class RController {

    @Autowired
    private TinTucService tinTucService;

    @Autowired
    private LoaiTinTucService loaiTinTucService;
    
    @GetMapping("/testAPITinTuc")
    public List<TinTuc> getAllTinTuc() {
        return tinTucService.getAllTinTuc();
    }

    @GetMapping("/testAPILoaiTinTuc")
    public List<LoaiTinTuc> getAllLoaiTinTuc() {
        return loaiTinTucService.getAllLoaiTinTuc();
    }
}