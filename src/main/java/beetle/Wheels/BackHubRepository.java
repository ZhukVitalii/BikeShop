package beetle.Wheels;

import beetle.Handlebars.Handlebar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Forks.BrakesType;

import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
public interface BackHubRepository extends JpaRepository<BackHub, Long>  {

        @Query("SELECT c FROM BackHub c WHERE c.wheelMaker = :wheelMaker")
        List<BackHub> findByWheelMakers(@Param("wheelMaker") WheelMaker wheelMaker, Pageable pageable);

        @Query("SELECT COUNT(c) FROM BackHub c WHERE c.wheelMaker = :wheelMaker")
        long countByWheelMakers(@Param("wheelMaker")  WheelMaker wheelMaker);

        @Query("SELECT c FROM BackHub c WHERE c.hubFixType = :hubFixType")
        List<BackHub> findByHubFixType(@Param("hubFixType") HubFixType hubFixType, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.bearingType = :bearingType")
        List<BackHub> findByBearingType(@Param("bearingType") BearingType bearingType, Pageable pageable);

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
        List<BackHub> findByRotorFixeType (@Param("rotorFixType")  RotorFixType rotorFixType, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.spokeNumber = :spokeNumber")
        List<BackHub> findBySpokeNumber (@Param("spokeNumber")SpokeNumber spokeNumber, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.backSprocketType = :backSprocketType")
        List<BackHub> findByBackSprocketType (@Param("backSprocketType")BackSprocketType backSprocketType, Pageable pageable);

        @Query("SELECT c FROM BackHub c WHERE c.backSprocketNumber = :backSprocketNumber")
        List<BackHub> findByBackSprocketNumber (@Param("backSprocketNumber")BackSprocketNumber backSprocketNumber, Pageable pageable);


        @Query("SELECT c FROM BackHub c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
        List<BackHub> findByPattern(@Param("pattern") String pattern, Pageable pageable);
    }

