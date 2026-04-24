package thigk2.phamminhquang.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.phamminhquang.models.TinTuc;

@Repository
public interface TinTucRepository extends JpaRepository<TinTuc, Integer> {
}