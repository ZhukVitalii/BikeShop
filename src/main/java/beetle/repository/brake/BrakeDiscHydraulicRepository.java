package beetle.repository.brake;

import beetle.entity.wheels.RotorFixType;
import beetle.entity.Manufacturer;
import beetle.entity.brake.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface BrakeDiscHydraulicRepository extends JpaRepository<BrakeDiscHydraulic, Long> {

    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.manufacturer = :manufacturer")
    List<BrakeDiscHydraulic> findByBrakeMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.manufacturer = :manufacturer")
    long countByBrakeMakers(@Param("manufacturer")  Manufacturer manufacturer);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.location = :location")
    List<BrakeDiscHydraulic> findByLocation(@Param("location") Location location, Pageable pageable);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.url = :url")
    List<BrakeDiscHydraulic> findByUrl(@Param("url") String url, Pageable pageable);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.article = :article")
    List<BrakeDiscHydraulic> findByArticle(@Param("article") Long article, Pageable pageable);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.lengthHydroline = :lengthHydroline")
    List<BrakeDiscHydraulic> findByLengthHydroline(@Param("lengthHydroline") LengthHydroline lengthHydroline, Pageable pageable);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.brakeLiquid = :brakeLiquid")
    List<BrakeDiscHydraulic> findByBrakeLiquid(@Param("brakeLiquid") BrakeLiquid brakeLiquid, Pageable pageable);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.rotorDiam = :rotorDiam")
    List<BrakeDiscHydraulic> findByRotorDiam(@Param("rotorDiam") RotorDiam rotorDiam, Pageable pageable);
    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.rotorFixType = :rotorFixType")
    List<BrakeDiscHydraulic> findByRotorFixType(@Param("rotorFixType") RotorFixType rotorFixType, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeDiscHydraulic> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}


