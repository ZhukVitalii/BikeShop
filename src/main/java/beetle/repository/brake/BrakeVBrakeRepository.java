package beetle.repository.brake;

import beetle.entity.Manufacturer;
import beetle.entity.brake.BrakeVBrake;
import beetle.entity.brake.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface BrakeVBrakeRepository extends JpaRepository<BrakeVBrake, Long> {

    @Query("SELECT c FROM BrakeVBrake c WHERE c.manufacturer = :manufacturer")
    List<BrakeVBrake> findByBrakeMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BrakeVBrake c WHERE c.manufacturer = :manufacturer")
    long countByBrakeMakers(@Param("manufacturer")  Manufacturer manufacturer);

    @Query("SELECT c FROM BrakeVBrake c WHERE c.location = :location")
    List<BrakeVBrake> findByLocation(@Param("location") Location location, Pageable pageable);

    @Query("SELECT c FROM BrakeVBrake c WHERE c.url = :url")
    List<BrakeVBrake> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BrakeVBrake c WHERE c.article = :article")
    List<BrakeVBrake> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BrakeVBrake c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeVBrake> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

