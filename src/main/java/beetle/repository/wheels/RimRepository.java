package beetle.repository.wheels;

import beetle.entity.Manufacturer;
import beetle.entity.wheels.SpokeNumber;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 14.06.2017.
 */
public interface RimRepository extends JpaRepository<Rim, Long> {
    @Query("SELECT c FROM Rim c WHERE c.manufacturer = :manufacturer")
    List<Rim> findByWheelMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Rim c WHERE c.manufacturer = :manufacturer")
    long countByWheelMakers(@Param("manufacturer")  Manufacturer manufacturer);

    @Query("SELECT c FROM Rim c WHERE c.url = :url")
    List<Rim> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Rim c WHERE c.article = :article")
    List<Rim> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Rim c WHERE c.bikeType = :bikeType")
    List<Rim> findByBikeType (@Param("bikeType")BikeType bikeType, Pageable pageable);

    @Query("SELECT c FROM Rim c WHERE c.wheelsDiam = :wheelsDiam")
    List<Rim> findByWheelsDiam (@Param("wheelsDiam")WheelsDiam wheelsDiam, Pageable pageable);


    @Query("SELECT c FROM Rim c WHERE c.spokeNumber = :spokeNumber")
    List<Rim> findBySpokeNumber (@Param("spokeNumber") SpokeNumber spokeNumber, Pageable pageable);

    @Query("SELECT c FROM Rim c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Rim> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}