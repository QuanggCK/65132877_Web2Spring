package thigk2.phamminhquang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.phamminhquang.models.LoaiSanPham;
import thigk2.phamminhquang.repos.LoaiSanPhamRepository;

import java.util.List;

@Service
public class LoaiSanPhamService {
    
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;
    

    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamRepository.findAll();
    }

    public LoaiSanPham getLoaiSanPham(int id) {
        return loaiSanPhamRepository.findById(id).orElse(null);
    }

    public void saveLoaiSanPham(LoaiSanPham loai) {
        loaiSanPhamRepository.save(loai);
    }
    
    public void deleteLoaiSanPham(int id) {
        if (loaiSanPhamRepository.existsById(id)) {
            loaiSanPhamRepository.deleteById(id);
        }
    }
}