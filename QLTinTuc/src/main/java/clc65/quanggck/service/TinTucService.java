package clc65.quanggck.service;

import clc65.quanggck.models.tintuc;
import clc65.quanggck.repos.TinTucRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TinTucService {

    private final TinTucRepository tinTucRepository;

    public TinTucService(TinTucRepository tinTucRepository) {
        this.tinTucRepository = tinTucRepository;
    }

    // 1. Lấy danh sách tất cả tin tức
    public List<tintuc> getAllTinTuc() {
        return tinTucRepository.findAll();
    }

    // 2. Lấy chi tiết một bài tin tức theo ID
    public tintuc getTinTucById(Integer id) {
        Optional<tintuc> optional = tinTucRepository.findById(id);
        return optional.orElse(null);
    }

    // 3. Thêm mới hoặc Cập nhật bài tin tức
    public tintuc saveTinTuc(tintuc tin) {
        // Nếu là bài viết mới chưa có ngày đăng, tự động gán ngày hiện tại
        if (tin.getNgayDang() == null) {
            tin.setNgayDang(LocalDate.now());
        }
        return tinTucRepository.save(tin);
    }

    // 4. Xóa bài tin tức
    public void deleteTinTuc(Integer id) {
        tinTucRepository.deleteById(id);
    }
}