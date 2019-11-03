package beetle.repository.brake;

import beetle.entity.Manufacturer;
import beetle.entity.brake.BrakeDiscMechanik;
import beetle.entity.brake.Location;
import beetle.entity.brake.RotorDiam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.entity.wheels.RotorFixType;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface BrakeDiscMechanikRepository extends JpaRepository<BrakeDiscMechanik, Long> {

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.manufacturer = :manufacturer")
    List<BrakeDiscMechanik> findByBrakeMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BrakeDiscMechanik c WHERE c.manufacturer = :manufacturer")
    long countByBrakeMakers(@Param("manufacturer")  Manufacturer manufacturer);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.location = :location")
    List<BrakeDiscMechanik> findByLocation(@Param("location") Location location, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.rotorDiam = :rotorDiam")
    List<BrakeDiscMechanik> findByRotorDiam(@Param("rotorDiam") RotorDiam rotorDiam, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.url = :url")
    List<BrakeDiscMechanik> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.article = :article")
    List<BrakeDiscMechanik> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.rotorFixType = :rotorFixType")
    List<BrakeDiscMechanik> findByRotorFixType(@Param("rotorFixType") RotorFixType rotorFixType, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeDiscMechanik> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
