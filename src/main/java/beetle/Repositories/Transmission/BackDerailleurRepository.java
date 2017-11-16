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
public interface BackDerailleurRepository extends JpaRepository<BackDerailleur, Long> {

    @Query("SELECT c FROM BackDerailleur c WHERE c.transmissionMaker = :transmissionMaker")
    List<BackDerailleur> findByTransmissionMakers(@Param("transmissionMaker") TransmissionMaker transmissionMaker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BackDerailleur c WHERE c.transmissionMaker = :transmissionMaker")
    long countByTransmissionMakers(@Param("transmissionMaker")  TransmissionMaker transmissionMaker);

    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<BackDerailleur> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.url = :url")
    List<BackDerailleur> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.article = :article")
    List<BackDerailleur> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.article = :article")
    BackDerailleur findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketMax = :backSprocketMax")
    List<BackDerailleur> findByBackSprocketMax(@Param("backSprocketMax") BackSprocketMax backSprocketMax, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketMin = :backSprocketMin")
    List<BackDerailleur> findByBackSprocketMin(@Param("backSprocketMin") BackSprocketMin backSprocketMin, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.pawLength = :pawLength")
    List<BackDerailleur> findByPawLength(@Param("pawLength") PawLength pawLength, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketNumber = :backSprocketNumber AND c.backSprocketMax = :backSprocketMax AND c.backSprocketMin = :backSprocketMin ")
    List<BackDerailleur> findBySprNumberAndSprMaxAndSprMin(@Param("backSprocketNumber" )BackSprocketNumber backSprocketNumber,
                                             @Param("backSprocketMax") BackSprocketMax backSprocketMax,
                                             @Param("backSprocketMin") BackSprocketMin backSprocketMin,
                                             Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BackDerailleur> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
