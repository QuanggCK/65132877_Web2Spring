package thigk2.phamminhquang.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thigk2.phamminhquang.models.LoaiTinTuc;
import thigk2.phamminhquang.models.TinTuc;

@Repository
public interface TinTucRepository extends JpaRepository<TinTuc, Integer> {
	List<TinTuc> findByLoaiTinTuc(LoaiTinTuc loaiTinTuc);
}