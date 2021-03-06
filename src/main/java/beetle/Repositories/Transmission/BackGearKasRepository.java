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
public interface BackGearKasRepository extends JpaRepository<BackGearKas, Long> {

    @Query("SELECT c FROM BackGearKas c WHERE c.maker = :maker")
    List<BackGearKas> findByTransmissionMakers(@Param("maker") TransmissionMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BackGearKas c WHERE c.maker = :maker")
    long countByTransmissionMakers(@Param("maker")  TransmissionMaker maker);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<BackGearKas> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.url = :url")
    List<BackGearKas> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.article = :article")
    List<BackGearKas> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.article = :article")
    BackGearKas findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketMax = :backSprocketMax")
    List<BackGearKas> findByBackSprocketMax(@Param("backSprocketMax") BackSprocketMax backSprocketMax, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketMin = :backSprocketMin")
    List<BackGearKas> findByBackSprocketMin(@Param("backSprocketMin") BackSprocketMin backSprocketMin, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE c.backSprocketSize = :backSprocketSize")
    List<BackGearKas> findByBackSprocketSize(@Param("backSprocketSize") BackSprocketSize backSprocketSize, Pageable pageable);

    @Query("SELECT c FROM BackGearKas c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BackGearKas> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

