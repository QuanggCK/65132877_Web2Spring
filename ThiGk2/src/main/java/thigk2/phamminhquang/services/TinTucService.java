package thigk2.phamminhquang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.phamminhquang.models.TinTuc;
import thigk2.phamminhquang.models.LoaiTinTuc;
import thigk2.phamminhquang.repos.TinTucRepository;
import thigk2.phamminhquang.repos.LoaiTinTucRepository;

import java.util.List;

@Service
public class TinTucService {

    @Autowired
    private TinTucRepository tinTucRepository;

    @Autowired
    private LoaiTinTucRepository loaiTinTucRepository;

    public List<TinTuc> getAllTinTuc() {
        return tinTucRepository.findAll();
    }
    
 // Thêm hàm lưu tin tức vào trong class TinTucService
    public void saveTinTuc(TinTuc tinTuc) {
        tinTucRepository.save(tinTuc);
    }


    public List<TinTuc> getTinTucByLoai(int idLoai) {

        LoaiTinTuc loai = loaiTinTucRepository.findById(idLoai).orElse(null);
        if (loai != null) {
            return tinTucRepository.findByLoaiTinTuc(loai);
        }
        return null;
    }

    public TinTuc getChiTietTin(int idTin) {
        return tinTucRepository.findById(idTin).orElse(null);
    }
    public void deleteTinTuc(int id) {
        tinTucRepository.deleteById(id);
    }
}