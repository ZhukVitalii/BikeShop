package beetle.Wheels;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Forks.WheelsDiam;
import beetle.Frames.Frame;
import beetle.Frames.FrameMaker;

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




    @Query("SELECT COUNT(c) FROM Wheel c WHERE c.spokeNumber = :spokeNumber")
    long countBySpokeNumber(@Param("spokeNumber")  SpokeNumber spokeNumber);

    @Query("SELECT COUNT(c) FROM Wheel c WHERE c.wheelMaker = :wheelMaker")
    long countByWheelMakers(@Param("wheelMaker")  WheelMaker wheelMaker);

    @Query("SELECT COUNT(c) FROM Wheel c WHERE c.rimWide = :rimWide")
    long countByRimWide(@Param("rimWide")  RimWide rimWide);

    @Query("SELECT COUNT(c) FROM Wheel c WHERE c.wheelsDiam = :wheelsDiam")
    long countByWheelsDiam(@Param("wheelsDiam")  WheelsDiam wheelsDiam);





    @Query("SELECT c FROM Wheel c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Wheel> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
