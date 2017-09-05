package beetle.Brakes;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface BrakeVBrakeRepository extends JpaRepository<BrakeVBrake, Long> {

    @Query("SELECT c FROM BrakeVBrake c WHERE c.brakeMaker = :brakeMaker")
    List<BrakeVBrake> findByBrakeMakers(@Param("brakeMaker") BrakeMaker brakeMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeVBrake c WHERE c.brakeMaker = :brakeMaker")
    long countByBrakeMakers(@Param("brakeMaker")  BrakeMaker brakeMaker);

    @Query("SELECT c FROM BrakeVBrake c WHERE c.location = :location")
    List<BrakeVBrake> findByLocation(@Param("location") Location location, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BrakeVBrake c WHERE c.location = :location")
    long countByLocation(@Param("location")  Location location);










    @Query("SELECT c FROM BrakeVBrake c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeVBrake> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

