package beetle.Transmissions;

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
    @Query("SELECT COUNT(c) FROM Pedal c WHERE c.bearingType = :bearingType")
    long countByBearingType(@Param("bearingType")  BearingType bearingType);

    @Query("SELECT c FROM Pedal c WHERE c.pedalType = :pedalType")
    List<Pedal> findByPedalType(@Param("pedalType")  PedalType pedalType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Pedal c WHERE c.pedalType = :pedalType")
    long countByPedalType(@Param("pedalType") PedalType pedalType);








    @Query("SELECT c FROM Pedal c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Pedal> findByPattern(@Param("pattern") String pattern, Pageable pageable);


}

