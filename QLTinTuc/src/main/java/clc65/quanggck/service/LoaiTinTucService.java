package clc65.quanggck.service;


import clc65.quanggck.models.loaitintuc;
import clc65.quanggck.repos.LoaiTinTucRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiTinTucService {

    // Nhúng Repository vào Service (Sử dụng Constructor Injection - Cách được khuyên dùng nhất)
    private final LoaiTinTucRepository loaiTinTucRepository;

    public LoaiTinTucService(LoaiTinTucRepository loaiTinTucRepository) {
        this.loaiTinTucRepository = loaiTinTucRepository;
    }

    // 1. Lấy danh sách tất cả loại tin
    public List<loaitintuc> getAllLoaiTinTuc() {
        return loaiTinTucRepository.findAll();
    }

    // 2. Lấy một loại tin theo ID
    public loaitintuc getLoaiTinTucById(Integer id) {
        Optional<loaitintuc> optional = loaiTinTucRepository.findById(id);
        return optional.orElse(null); // Trả về null nếu không tìm thấy
    }

    // 3. Thêm mới hoặc Cập nhật loại tin (Spring Data JPA dùng chung hàm save)
    public loaitintuc saveLoaiTinTuc(loaitintuc loaiTinTuc) {
        return loaiTinTucRepository.save(loaiTinTuc);
    }

    // 4. Xóa loại tin theo ID
    public void deleteLoaiTinTuc(Integer id) {
        loaiTinTucRepository.deleteById(id);
    }
}