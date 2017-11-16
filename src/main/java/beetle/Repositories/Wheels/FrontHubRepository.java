package beetle.Repositories.Wheels;

import beetle.Entities.Wheels.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Entities.Forks.BrakesType;

import java.util.List;

/**
 * Created by VitaliiZhuk on 18.06.2017.
 */
public interface FrontHubRepository extends JpaRepository<FrontHub, Long> {

    @Query("SELECT c FROM FrontHub c WHERE c.wheelMaker = :wheelMaker")
    List<FrontHub> findByWheelMakers(@Param("wheelMaker") WheelMaker wheelMaker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM FrontHub c WHERE c.wheelMaker = :wheelMaker")
    long countByWheelMakers(@Param("wheelMaker")  WheelMaker wheelMaker);

    @Query("SELECT c FROM FrontHub c WHERE c.hubFixType = :hubFixType")
    List<FrontHub> findByHubFixType(@Param("hubFixType") HubFixType hubFixType, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.bearingType = :bearingType")
    List<FrontHub> findByBearingType(@Param("bearingType") BearingType bearingType, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.url = :url")
    List<FrontHub> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.article = :article")
    List<FrontHub> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.axisLength = :axisLength")
    List<FrontHub> findByAxisLength (@Param("axisLength") AxisLength axisLength, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.article = :article")
    FrontHub findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM FrontHub c WHERE c.axisDiam = :axisDiam")
    List<FrontHub> findByAxisDiam (@Param("axisDiam") AxisDiam axisDiam, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.brakesType = :brakesType")
    List<FrontHub> findByBrakesType (@Param("brakesType")BrakesType brakesType, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.rotorFixType = :rotorFixType")
    List<FrontHub> findByRotorFixeType (@Param("rotorFixType") RotorFixType rotorFixType, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE c.spokeNumber = :spokeNumber")
    List<FrontHub> findBySpokeNumber (@Param("spokeNumber")SpokeNumber spokeNumber, Pageable pageable);

    @Query("SELECT c FROM FrontHub c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<FrontHub> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
