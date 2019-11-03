package beetle.repository.transmission;

import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.BackSprocketNumber;
import beetle.entity.transmission.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
public interface CrankRepository extends JpaRepository<Crank, Long> {

    @Query("SELECT c FROM Crank c WHERE c.manufacturer = :manufacturer")
    List<Crank> findByTransmissionMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Crank c WHERE c.manufacturer = :manufacturer")
    long countByTransmissionMakers(@Param("manufacturer") Manufacturer manufacturer);

    @Query("SELECT c FROM Crank c WHERE c.bikeType = :bikeType")
    List<Crank> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.url = :url")
    List<Crank> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.article = :article")
    List<Crank> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<Crank> findByBackSprocketNumber(@Param("backSprocketNumber")BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketNumber = :frontSprocketNumber")
    List<Crank> findByFrontSprocketNumber(@Param("frontSprocketNumber") FrontSprocketNumber frontSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketSize = :frontSprocketSize")
    List<Crank> findByFrontSprocketSize(@Param("frontSprocketSize") FrontSprocketSize frontSprocketSize, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketMax = :frontSprocketMax")
    List<Crank> findByFrontSprocketMax(@Param("frontSprocketMax") FrontSprocketMax frontSprocketMax, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.frontSprocketMin = :frontSprocketMin")
    List<Crank> findByFrontSprocketMin(@Param("frontSprocketMin") FrontSprocketMin frontSprocketMin, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.crankLength = :crankLength")
    List<Crank> findByCrankLength(@Param("crankLength") CrankLength crankLength, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE c.bracketType = :bracketType")
    List<Crank> findByBracketType(@Param("bracketType") BracketType bracketType, Pageable pageable);

    @Query("SELECT c FROM Crank c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Crank> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

