package beetle.repository.transmission;

import beetle.entity.Manufacturer;
import beetle.entity.transmission.*;
import beetle.entity.wheels.BackSprocketNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface BackDerailleurRepository extends JpaRepository<BackDerailleur, Long> {

    @Query("SELECT c FROM BackDerailleur c WHERE c.manufacturer = :manufacturer")
    List<BackDerailleur> findByTransmissionMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BackDerailleur c WHERE c.manufacturer = :manufacturer")
    long countByTransmissionMakers(@Param("manufacturer") Manufacturer manufacturer);

    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<BackDerailleur> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.url = :url")
    List<BackDerailleur> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BackDerailleur c WHERE c.article = :article")
    List<BackDerailleur> findByArticle(@Param("article") Long article, Pageable pageable);

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
