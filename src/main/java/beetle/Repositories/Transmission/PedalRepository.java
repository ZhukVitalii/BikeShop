package beetle.Repositories.Transmission;

import beetle.Entities.Transmission.Pedal;
import beetle.Entities.Transmission.PedalType;
import beetle.Entities.Transmission.TransmissionMaker;
import beetle.Entities.Wheels.BearingType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface PedalRepository extends JpaRepository<Pedal, Long> {

    @Query("SELECT c FROM Pedal c WHERE c.maker = :maker")
    List<Pedal> findByTransmissionMakers(@Param("maker") TransmissionMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Pedal c WHERE c.maker = :maker")
    long countByTransmissionMakers(@Param("maker")  TransmissionMaker maker);

    @Query("SELECT c FROM Pedal c WHERE c.bearingType = :bearingType")
    List<Pedal> findByBearingType(@Param("bearingType") BearingType bearingType, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE c.url = :url")
    List<Pedal> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE c.article = :article")
    List<Pedal> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE c.article = :article")
    Pedal findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM Pedal c WHERE c.pedalType = :pedalType")
    List<Pedal> findByPedalType(@Param("pedalType") PedalType pedalType, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Pedal> findByPattern(@Param("pattern") String pattern, Pageable pageable);

}

