package beetle.Repositories.Brakes;

import beetle.Entities.Brakes.BrakeDiscMechanik;
import beetle.Entities.Brakes.BrakeMaker;
import beetle.Entities.Brakes.Location;
import beetle.Entities.Brakes.RotorDiam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Entities.Wheels.RotorFixType;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface BrakeDiscMechanikRepository extends JpaRepository<BrakeDiscMechanik, Long> {

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.brakeMaker = :brakeMaker")
    List<BrakeDiscMechanik> findByBrakeMakers(@Param("brakeMaker") BrakeMaker brakeMaker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BrakeDiscMechanik c WHERE c.brakeMaker = :brakeMaker")
    long countByBrakeMakers(@Param("brakeMaker")  BrakeMaker brakeMaker);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.location = :location")
    List<BrakeDiscMechanik> findByLocation(@Param("location") Location location, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.rotorDiam = :rotorDiam")
    List<BrakeDiscMechanik> findByRotorDiam(@Param("rotorDiam") RotorDiam rotorDiam, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.url = :url")
    List<BrakeDiscMechanik> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.article = :article")
    List<BrakeDiscMechanik> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.article = :article")
    BrakeDiscMechanik findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE c.rotorFixType = :rotorFixType")
    List<BrakeDiscMechanik> findByRotorFixType(@Param("rotorFixType") RotorFixType rotorFixType, Pageable pageable);

    @Query("SELECT c FROM BrakeDiscMechanik c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeDiscMechanik> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
