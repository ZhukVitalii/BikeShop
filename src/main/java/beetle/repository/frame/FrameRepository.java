package beetle.repository.frame;

import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.transmission.BracketWide;
import beetle.entity.frame.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FrameRepository extends JpaRepository<Frame, Long> {
    @Query("SELECT c FROM Frame c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Frame> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
