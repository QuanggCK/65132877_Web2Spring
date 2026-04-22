package thigk2.phamminhquang.service;

import thigk2.phamminhquang.models.LoaiSanPham;
import thigk2.phamminhquang.repo.LoaiSanPhamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSanPhamService {

    private final LoaiSanPhamRepository loaiSanPhamRepository;

    public LoaiSanPhamService(LoaiSanPhamRepository loaiSanPhamRepository) {
        this.loaiSanPhamRepository = loaiSanPhamRepository;
    }

    public List<LoaiSanPham> getAllLoai() {
        return loaiSanPhamRepository.findAll();
    }

    public LoaiSanPham getLoaiById(Integer id) {
        Optional<LoaiSanPham> optional = loaiSanPhamRepository.findById(id);
        return optional.orElse(null); 
    }

    public LoaiSanPham saveLoai(LoaiSanPham loaiSanPham) {
        return loaiSanPhamRepository.save(loaiSanPham);
    }

    public void deleteLoai(Integer id) {
        loaiSanPhamRepository.deleteById(id);
    }
}