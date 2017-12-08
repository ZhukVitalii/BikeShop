package beetle.Repositories.Transmission;

import beetle.Entities.Transmission.*;
import beetle.Entities.Wheels.BackSprocketNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface FrontDerailleurRepository extends JpaRepository<FrontDerailleur, Long> {

    @Query("SELECT c FROM FrontDerailleur c WHERE c.maker = :maker")
    List<FrontDerailleur> findByTransmissionMakers(@Param("maker") TransmissionMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM FrontDerailleur c WHERE c.maker = :maker")
    long countByTransmissionMakers(@Param("maker")  TransmissionMaker maker);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.frontSprocketNumber = :frontSprocketNumber")
    List<FrontDerailleur> findByFrontSprocketNumber(@Param("frontSprocketNumber") FrontSprocketNumber frontSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<FrontDerailleur> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.url = :url")
    List<FrontDerailleur> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.article = :article")
    List<FrontDerailleur> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.article = :article")
    FrontDerailleur findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.frontSprocketMax = :frontSprocketMax")
    List<FrontDerailleur> findByFrontSprocketMax(@Param("frontSprocketMax") FrontSprocketMax frontSprocketMax, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.frontSprocketMin = :frontSprocketMin")
    List<FrontDerailleur> findByFrontSprocketMin(@Param("frontSprocketMin") FrontSprocketMin frontSprocketMin, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.teethCapasity = :teethCapasity")
    List<FrontDerailleur> findByTeethCapasity(@Param("teethCapasity") TeethCapasity teethCapasity, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.frontDerailleurFixType = :frontDerailleurFixType")
    List<FrontDerailleur> findByFrontDerailleurFixType(@Param("frontDerailleurFixType") FrontDerailleurFixType frontDerailleurFixType, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.collarDiam = :collarDiam")
    List<FrontDerailleur> findByCollarDiam(@Param("collarDiam") CollarDiam collarDiam, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.tractionType = :tractionType")
    List<FrontDerailleur> findByTractionType(@Param("tractionType") TractionType tractionType, Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE c.frontSprocketNumber = :frontSprocketNumber AND c.backSprocketNumber = :backSprocketNumber AND c.frontSprocketMax = :frontSprocketMax AND c.frontSprocketMin = :frontSprocketMin ")
    List<FrontDerailleur> findByFrSprNumberAndBackSprNumberAndFrSprMaxAndFrSprMin(
                                                @Param("frontSprocketNumber" )FrontSprocketNumber frontSprocketNumber,
                                                @Param("backSprocketNumber" )BackSprocketNumber backSprocketNumber,
                                                @Param("frontSprocketMax") FrontSprocketMax frontSprocketMax,
                                                @Param("frontSprocketMin") FrontSprocketMin frontSprocketMin,
                                                Pageable pageable);

    @Query("SELECT c FROM FrontDerailleur c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<FrontDerailleur> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

