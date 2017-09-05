package beetle.Transmissions;

import beetle.Wheels.BearingType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
public interface BracketRepository extends JpaRepository<Bracket, Long> {

    @Query("SELECT c FROM Bracket c WHERE c.transmissionMaker = :transmissionMaker")
    List<Bracket> findByTransmissionMakers(@Param("transmissionMaker") TransmissionMaker transmissionMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.transmissionMaker = :transmissionMaker")
    long countByTransmissionMakers(@Param("transmissionMaker")  TransmissionMaker transmissionMaker);

    @Query("SELECT c FROM Bracket c WHERE c.bracketAxisLength = :bracketAxisLength")
    List<Bracket> findByBracketAxisLength(@Param("bracketAxisLength") BracketAxisLength bracketAxisLength, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.bracketAxisLength = :bracketAxisLength")
    long countByBracketAxisLength(@Param("bracketAxisLength")  BracketAxisLength bracketAxisLength);

    @Query("SELECT c FROM Bracket c WHERE c.bracketWide = :bracketWide")
    List<Bracket> findByBracketWide(@Param("bracketWide") BracketWide bracketWide, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.bracketWide = :bracketWide")
    long countByBracketWide(@Param("bracketWide") BracketWide bracketWide);

    @Query("SELECT c FROM Bracket c WHERE c.bracketType = :bracketType")
    List<Bracket> findByBracketType(@Param("bracketType") BracketType bracketType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.bracketType = :bracketType")
    long countByBracketType(@Param("bracketType")  BracketType bracketType);

    @Query("SELECT c FROM Bracket c WHERE c.bearingType = :bearingType")
    List<Bracket> findByBearingType(@Param("bearingType") BearingType bearingType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.bearingType = :bearingType")
    long countByBearingType(@Param("bearingType")  BearingType bearingType);

    @Query("SELECT c FROM Bracket c WHERE c.carvingType = :carvingType")
    List<Bracket> findByCarvingType(@Param("carvingType") CarvingType carvingType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.carvingType = :carvingType")
    long countByCarvingType(@Param("carvingType")  CarvingType carvingType);








    @Query("SELECT c FROM Bracket c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Bracket> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

