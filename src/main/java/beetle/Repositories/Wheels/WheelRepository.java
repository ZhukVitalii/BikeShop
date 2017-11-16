package beetle.Repositories.Wheels;

import beetle.Entities.Forks.BrakesType;
import beetle.Entities.Frames.BikeType;
import beetle.Entities.Wheels.RimWide;
import beetle.Entities.Wheels.SpokeNumber;
import beetle.Entities.Wheels.Wheel;
import beetle.Entities.Wheels.WheelMaker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Entities.Forks.WheelsDiam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
public interface WheelRepository extends JpaRepository<Wheel, Long> {
    @Query("SELECT c FROM Wheel c WHERE c.wheelMaker = :wheelMaker")
    List<Wheel> findByWheelMakers(@Param("wheelMaker") WheelMaker wheelMaker, Pageable pageable);

    @Query("SELECT c FROM Wheel c WHERE c.spokeNumber = :spokeNumber")
    List<Wheel> findBySpokeNumber(@Param("spokeNumber") SpokeNumber spokeNumber, Pageable pageable);

    @Query("SELECT c FROM Wheel c WHERE c.rimWide = :rimWide")
    List<Wheel> findByRimWide(@Param("rimWide") RimWide rimWide, Pageable pageable);

    @Query("SELECT c FROM Wheel c WHERE c.wheelsDiam = :wheelsDiam")
    List<Wheel> findByWheelsDiam(@Param("wheelsDiam")WheelsDiam wheelsDiam, Pageable pageable);

    @Query("SELECT c FROM Wheel c WHERE c.url = :url")
    List<Wheel> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Wheel c WHERE c.article = :article")
    List<Wheel> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Wheel c WHERE c.article = :article")
    Wheel findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM Wheel c WHERE c.bikeType = :bikeType AND c.wheelsDiam = :wheelsDiam AND c.brakesType = :brakesType ")
    List<Wheel> findByTypeAndWhDiamAndBrType(@Param("bikeType" )BikeType bikeType,
                                                       @Param("wheelsDiam") WheelsDiam wheelsDiam,
                                                       @Param("brakesType") BrakesType brakesType,
                                                       Pageable pageable);


    @Query("SELECT COUNT(c) FROM Wheel c WHERE c.wheelMaker = :wheelMaker")
    long countByWheelMakers(@Param("wheelMaker")  WheelMaker wheelMaker);

    @Query("SELECT c FROM Wheel c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Wheel> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
