package beetle.repository.wheels;

import beetle.entity.Manufacturer;
import beetle.entity.wheels.RotorFixType;
import beetle.entity.wheels.SpokeNumber;
import beetle.entity.wheels.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.entity.forks.BrakesType;

import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
public interface BackHubRepository extends JpaRepository<BackHub, Long>  {

        @Query("SELECT c FROM BackHub c WHERE c.manufacturer = :manufacturer")
        List<BackHub> findByWheelMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

        @Query("SELECT COUNT(c) FROM BackHub c WHERE c.manufacturer = :manufacturer")
        long countByWheelMakers(@Param("manufacturer")  Manufacturer manufacturer);

        @Query("SELECT c FROM BackHub c WHERE c.hubFixType = :hubFixType")
        List<BackHub> findByHubFixType(@Param("hubFixType") HubFixType hubFixType, Pageable pageable);


        @Query("SELECT c FROM BackHub c WHERE c.url = :url")
        List<BackHub> findByUrl(@Param("url") String url, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.article = :article")
        List<BackHub> findByArticle(@Param("article") Long article, Pageable pageable);


        @Query("SELECT c FROM BackHub c WHERE c.axisLength = :axisLength")
        List<BackHub> findByAxisLength (@Param("axisLength") AxisLength axisLength, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.axisDiam = :axisDiam")
        List<BackHub> findByAxisDiam (@Param("axisDiam") AxisDiam axisDiam, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.brakesType = :brakesType")
        List<BackHub> findByBrakesType (@Param("brakesType")BrakesType brakesType, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.rotorFixType = :rotorFixType")
        List<BackHub> findByRotorFixeType (@Param("rotorFixType") RotorFixType rotorFixType, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.spokeNumber = :spokeNumber")
        List<BackHub> findBySpokeNumber (@Param("spokeNumber") SpokeNumber spokeNumber, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.backSprocketType = :backSprocketType")
        List<BackHub> findByBackSprocketType (@Param("backSprocketType") BackSprocketType backSprocketType, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.backSprocketNumber = :backSprocketNumber")
        List<BackHub> findByBackSprocketNumber (@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);


        @Query("SELECT c FROM BackHub c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
        List<BackHub> findByPattern(@Param("pattern") String pattern, Pageable pageable);
    }

