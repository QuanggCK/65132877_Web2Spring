package thigk2.phamminhquang.service;

import thigk2.phamminhquang.models.SanPham;
import thigk2.phamminhquang.repo.SanPhamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {


    private final SanPhamRepository sanPhamRepository;

    public SanPhamService(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }


    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }


    public SanPham getSanPhamById(Integer id) {
        Optional<SanPham> optional = sanPhamRepository.findById(id);
        return optional.orElse(null); 
    }

    public SanPham saveSanPham(SanPham sp) {
        return sanPhamRepository.save(sp);
    }

    public void deleteSanPham(Integer id) {
        sanPhamRepository.deleteById(id);
    }


    public List<SanPham> getSanPhamByLoai(Integer idLoai) {
        return sanPhamRepository.findAll().stream()
                .filter(sp -> sp.getLoaiSanPham() != null && sp.getLoaiSanPham().getIdLoai().equals(idLoai))
                .toList();
    }
}