package beetle.Transmissions;

import beetle.Bakes.BikeType;
import beetle.Wheels.BackSprocketNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
public interface CrankRepository extends JpaRepository<Crank, Long> {

    @Query("SELECT c FROM Crank c WHERE c.transmissionMaker = :transmissionMaker")
    List<Crank> findByTransmissionMakers(@Param("transmissionMaker") TransmissionMaker transmissionMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.transmissionMaker = :transmissionMaker")
    long countByTransmissionMakers(@Param("transmissionMaker")  TransmissionMaker transmissionMaker);

    @Query("SELECT c FROM Crank c WHERE c.bikeType = :bikeType")
    List<Crank> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.bikeType = :bikeType")
    long countByBikeType(@Param("bikeType")  BikeType bikeType);

    @Query("SELECT c FROM Crank c WHERE c.url = :url")
    List<Crank> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.article = :article")
    List<Crank> findByArticle(@Param("article") Long article, Pageable pageable);


    @Query("SELECT c FROM Crank c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<Crank> findByBackSprocketNumber(@Param("backSprocketNumber")BackSprocketNumber backSprocketNumber, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.backSprocketNumber = :backSprocketNumber")
    long countByBackSprocketNumber(@Param("backSprocketNumber")  BackSprocketNumber backSprocketNumber);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketNumber = :frontSprocketNumber")
    List<Crank> findByFrontSprocketNumber(@Param("frontSprocketNumber")  FrontSprocketNumber frontSprocketNumber, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.frontSprocketNumber = :frontSprocketNumber")
    long countByFrontSprocketNumber(@Param("frontSprocketNumber") FrontSprocketNumber frontSprocketNumber);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketSize = :frontSprocketSize")
    List<Crank> findByFrontSprocketSize(@Param("frontSprocketSize")  FrontSprocketSize frontSprocketSize, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.frontSprocketSize = :frontSprocketSize")
    long countByFrontSprocketSize(@Param("frontSprocketSize") FrontSprocketSize frontSprocketSize);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketMax = :frontSprocketMax")
    List<Crank> findByFrontSprocketMax(@Param("frontSprocketMax")  FrontSprocketMax frontSprocketMax, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.frontSprocketMax = :frontSprocketMax")
    long countByFrontSprocketMax(@Param("frontSprocketMax") FrontSprocketMax frontSprocketMax);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketMin = :frontSprocketMin")
    List<Crank> findByFrontSprocketMin(@Param("frontSprocketMin")  FrontSprocketMin frontSprocketMin, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.frontSprocketMin = :frontSprocketMin")
    long countByFrontSprocketMin(@Param("frontSprocketMin") FrontSprocketMin frontSprocketMin);

    @Query("SELECT c FROM Crank c WHERE c.crankLength = :crankLength")
    List<Crank> findByCrankLength(@Param("crankLength")  CrankLength crankLength, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.crankLength = :crankLength")
    long countByCrankLength(@Param("crankLength") CrankLength crankLength);

    @Query("SELECT c FROM Crank c WHERE c.bracketType = :bracketType")
    List<Crank> findByBracketType(@Param("bracketType")  BracketType bracketType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Crank c WHERE c.bracketType = :bracketType")
    long countByBracketType(@Param("bracketType") BracketType bracketType);







    @Query("SELECT c FROM Crank c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Crank> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

