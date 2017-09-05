package beetle.Brakes;

import beetle.Wheels.RotorFixType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface BrakeDiscHydraulicRepository extends JpaRepository<BrakeDiscHydraulic, Long> {

    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.brakeMaker = :brakeMaker")
    List<BrakeDiscHydraulic> findByBrakeMakers(@Param("brakeMaker") BrakeMaker brakeMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.brakeMaker = :brakeMaker")
    long countByBrakeMakers(@Param("brakeMaker")  BrakeMaker brakeMaker);

    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.location = :location")
    List<BrakeDiscHydraulic> findByLocation(@Param("location") Location location, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.location = :location")
    long countByLocation(@Param("location")  Location location);



    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.lengthHydroline = :lengthHydroline")
    List<BrakeDiscHydraulic> findByLengthHydroline(@Param("lengthHydroline") LengthHydroline lengthHydroline, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.lengthHydroline = :lengthHydroline")
    long countByLengthHydroline(@Param("lengthHydroline")  LengthHydroline lengthHydroline);

    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.brakeLiquid = :brakeLiquid")
    List<BrakeDiscHydraulic> findByBrakeLiquid(@Param("brakeLiquid") BrakeLiquid brakeLiquid, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.brakeLiquid = :brakeLiquid")
    long countByBrakeLiquid(@Param("brakeLiquid")  BrakeLiquid brakeLiquid);

    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.rotorDiam = :rotorDiam")
    List<BrakeDiscHydraulic> findByRotorDiam(@Param("rotorDiam") RotorDiam rotorDiam, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.rotorDiam = :rotorDiam")
    long countByRotorDiam(@Param("rotorDiam")  RotorDiam rotorDiam);




    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE c.rotorFixType = :rotorFixType")
    List<BrakeDiscHydraulic> findByRotorFixType(@Param("rotorFixType") RotorFixType rotorFixType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeDiscHydraulic c WHERE c.rotorFixType = :rotorFixType")
    long countByRotorFixType (@Param("rotorFixType")  RotorFixType rotorFixType);






    @Query("SELECT c FROM BrakeDiscHydraulic c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeDiscHydraulic> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}


