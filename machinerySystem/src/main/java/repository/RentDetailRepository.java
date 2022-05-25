package repository;

import entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDetailRepository extends JpaRepository<RentDetail, Long> {
}
