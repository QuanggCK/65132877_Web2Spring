package clc65.quanggck.repos;

import clc65.quanggck.models.loaitintuc; // Import model của bạn vào
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTinTucRepository extends JpaRepository<loaitintuc, Integer> {
}