package thigk2.phamminhquang.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import thigk2.phamminhquang.models.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    NguoiDung findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
}