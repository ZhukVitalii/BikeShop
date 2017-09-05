package beetle.Forks;

import beetle.Bakes.BikeType;
import beetle.Frames.Frame;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */
public interface ForkRepository extends JpaRepository<Fork, Long> {
    @Query("SELECT c FROM Fork c WHERE c.forkMaker = :forkMaker")
    List<Fork> findByForkMakers(@Param("forkMaker") ForkMaker forkMaker, Pageable pageable);


    @Query("SELECT c FROM Fork c WHERE c.tubeDiameter = :tubeDiameter")
    List<Fork> findByTubeDiameter(@Param("tubeDiameter") TubeDiameter tubeDiameter, Pageable pageable);


    @Query("SELECT c FROM Fork c WHERE c.bikeType = :bikeType")
    List<Fork> findByBikeType(@Param("bikeType") BikeType bikeType, Pageable pageable);

    @Query("SELECT c FROM Fork c WHERE c.wheelsDiam = :wheelsDiam")
    List<Fork> findByWheelsDiam(@Param("wheelsDiam") WheelsDiam wheelsDiam, Pageable pageable);

    @Query("SELECT c FROM Fork c WHERE c.brakesType = :brakesType")
    List<Fork> findByBrakesType(@Param("brakesType") BrakesType brakesType, Pageable pageable);

    @Query("SELECT c FROM Fork c WHERE c.url = :url")
    List<Fork> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Fork c WHERE c.article = :article")
    List<Fork> findByArticle(@Param("article") Long article, Pageable pageable);




    @Query("SELECT COUNT(c) FROM Fork c WHERE c.forkMaker = :forkMaker")
    long countByForkMaker(@Param("forkMaker") ForkMaker forkMaker);

    @Query("SELECT COUNT(c) FROM Fork c WHERE c.bikeType = :bikeType")
    long countByBikeType(@Param("bikeType") BikeType bikeType);

    @Query("SELECT COUNT(c) FROM Fork c WHERE c.tubeDiameter = :tubeDiameter")
    long countByTubeDiameter(@Param("tubeDiameter") TubeDiameter tubeDiameter);

    @Query("SELECT COUNT(c) FROM Fork c WHERE c.wheelsDiam = :wheelsDiam")
    long countByWheelsDiam(@Param("wheelsDiam") WheelsDiam wheelsDiam);

    @Query("SELECT COUNT(c) FROM Fork c WHERE c.brakesType = :brakesType")
    long countByBrakesType(@Param("brakesType") BrakesType brakesType);




    @Query("SELECT c FROM Fork c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Fork> findByPattern(@Param("pattern") String pattern, Pageable pageable);


}
