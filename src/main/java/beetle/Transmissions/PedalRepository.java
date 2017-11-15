package beetle.Transmissions;

import beetle.Frames.Frame;
import beetle.Wheels.BearingType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface PedalRepository extends JpaRepository<Pedal, Long> {

    @Query("SELECT c FROM Pedal c WHERE c.transmissionMaker = :transmissionMaker")
    List<Pedal> findByTransmissionMakers(@Param("transmissionMaker") TransmissionMaker transmissionMaker, org.springframework.data.domain.Pageable pageable);

    @Query("SELECT COUNT(c) FROM Pedal c WHERE c.transmissionMaker = :transmissionMaker")
    long countByTransmissionMakers(@Param("transmissionMaker")  TransmissionMaker transmissionMaker);

    @Query("SELECT c FROM Pedal c WHERE c.bearingType = :bearingType")
    List<Pedal> findByBearingType(@Param("bearingType") BearingType bearingType, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE c.url = :url")
    List<Pedal> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE c.article = :article")
    List<Pedal> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE c.article = :article")
    Pedal findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM Pedal c WHERE c.pedalType = :pedalType")
    List<Pedal> findByPedalType(@Param("pedalType")  PedalType pedalType, Pageable pageable);

    @Query("SELECT c FROM Pedal c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Pedal> findByPattern(@Param("pattern") String pattern, Pageable pageable);

}

