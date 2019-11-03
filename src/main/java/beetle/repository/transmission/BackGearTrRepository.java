package beetle.repository.transmission;

import beetle.entity.wheels.BackSprocketNumber;
import beetle.entity.Manufacturer;
import beetle.entity.transmission.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface BackGearTrRepository extends JpaRepository<BackGearTr, Long> {

    @Query("SELECT c FROM BackGearTr c WHERE c.manufacturer = :manufacturer")
    List<BackGearTr> findByTransmissionMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BackGearTr c WHERE c.manufacturer = :manufacturer")
    long countByTransmissionMakers(@Param("manufacturer")  Manufacturer manufacturer);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<BackGearTr> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.url = :url")
    List<BackGearTr> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.article = :article")
    List<BackGearTr> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketMax = :backSprocketMax")
    List<BackGearTr> findByBackSprocketMax(@Param("backSprocketMax") BackSprocketMax backSprocketMax, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketMin = :backSprocketMin")
    List<BackGearTr> findByBackSprocketMin(@Param("backSprocketMin") BackSprocketMin backSprocketMin, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketSize = :backSprocketSize")
    List<BackGearTr> findByBackSprocketSize(@Param("backSprocketSize") BackSprocketSize backSprocketSize, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BackGearTr> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}