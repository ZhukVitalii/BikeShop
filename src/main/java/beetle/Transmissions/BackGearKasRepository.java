package beetle.Transmissions;

import beetle.Wheels.BackSprocketNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface BackGearKasRepository extends JpaRepository<BackGearKas, Long> {

    @Query("SELECT c FROM BackGearKas c WHERE c.transmissionMaker = :transmissionMaker")
    List<BackGearKas> findByTransmissionMakers(@Param("transmissionMaker") TransmissionMaker transmissionMaker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BackGearKas c WHERE c.transmissionMaker = :transmissionMaker")
    long countByTransmissionMakers(@Param("transmissionMaker")  TransmissionMaker transmissionMaker);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<BackGearKas> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.url = :url")
    List<BackGearKas> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.article = :article")
    List<BackGearKas> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketMax = :backSprocketMax")
    List<BackGearKas> findByBackSprocketMax(@Param("backSprocketMax") BackSprocketMax backSprocketMax, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketMin = :backSprocketMin")
    List<BackGearKas> findByBackSprocketMin(@Param("backSprocketMin") BackSprocketMin backSprocketMin, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketSize = :backSprocketSize")
    List<BackGearKas> findByBackSprocketSize(@Param("backSprocketSize") BackSprocketSize backSprocketSize, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BackGearKas> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

