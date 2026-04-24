package clc65.quanggck.service;


import clc65.quanggck.models.loaitintuc;
import clc65.quanggck.repos.LoaiTinTucRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiTinTucService {


    private final LoaiTinTucRepository loaiTinTucRepository;

    public LoaiTinTucService(LoaiTinTucRepository loaiTinTucRepository) {
        this.loaiTinTucRepository = loaiTinTucRepository;
    }


    public List<loaitintuc> getAllLoaiTinTuc() {
        return loaiTinTucRepository.findAll();
    }

    public loaitintuc getLoaiTinTucById(Integer id) {
        Optional<loaitintuc> optional = loaiTinTucRepository.findById(id);
        return optional.orElse(null); 
    }


    public loaitintuc saveLoaiTinTuc(loaitintuc loaiTinTuc) {
        return loaiTinTucRepository.save(loaiTinTuc);
    }

    public void deleteLoaiTinTuc(Integer id) {
        loaiTinTucRepository.deleteById(id);
    }
}