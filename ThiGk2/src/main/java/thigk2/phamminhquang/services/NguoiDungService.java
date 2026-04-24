package thigk2.phamminhquang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.phamminhquang.models.NguoiDung;
import thigk2.phamminhquang.repos.NguoiDungRepository;

@Service
public class NguoiDungService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public NguoiDung checkLogin(String username, String password) {
        return nguoiDungRepository.findByTenDangNhapAndMatKhau(username, password);
    }
}