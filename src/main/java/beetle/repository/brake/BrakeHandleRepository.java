package beetle.repository.brake;

import beetle.entity.Manufacturer;
import beetle.entity.brake.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
public interface BrakeHandleRepository extends JpaRepository<BrakeHandle, Long> {


    @Query("SELECT c FROM BrakeHandle c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeHandle> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

