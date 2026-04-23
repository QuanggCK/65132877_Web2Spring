package thigk2.phamminhquang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.phamminhquang.models.SanPham;
import thigk2.phamminhquang.repos.SanPhamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    public SanPham getSanPham (int id) {
    	return sanPhamRepository.getReferenceById(id);
    }

    public void saveSanPham(SanPham sanpham) {
        sanPhamRepository.save(sanpham);
    }


    public void deleteSanPham(int id) {
        if (sanPhamRepository.existsById(id)) {
            sanPhamRepository.deleteById(id);
        }
    }
}