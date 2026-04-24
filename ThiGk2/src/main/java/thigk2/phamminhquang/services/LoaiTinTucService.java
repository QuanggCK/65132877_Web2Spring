package thigk2.phamminhquang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.phamminhquang.models.LoaiTinTuc;
import thigk2.phamminhquang.repos.LoaiTinTucRepository;
import java.util.List;

@Service
public class LoaiTinTucService {

    @Autowired
    private LoaiTinTucRepository loaiTinTucRepository;


    public List<LoaiTinTuc> getAllLoaiTinTuc() {
        return loaiTinTucRepository.findAll();
    }
    
    public LoaiTinTuc getLoaiById(int id) {
        return loaiTinTucRepository.findById(id).orElse(null);
    }
}