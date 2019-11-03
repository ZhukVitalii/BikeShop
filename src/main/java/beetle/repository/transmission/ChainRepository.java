package beetle.repository.transmission;

import beetle.entity.wheels.BackSprocketNumber;
import beetle.entity.Manufacturer;
import beetle.entity.transmission.Chain;
import beetle.entity.transmission.ChainElementNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface ChainRepository extends JpaRepository<Chain, Long> {

    @Query("SELECT c FROM Chain c WHERE c.manufacturer = :manufacturer")
    List<Chain> findByTransmissionMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Chain c WHERE c.manufacturer = :manufacturer")
    long countByTransmissionMakers(@Param("manufacturer")  Manufacturer manufacturer);

    @Query("SELECT c FROM Chain c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<Chain> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM Chain c WHERE c.url = :url")
    List<Chain> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Chain c WHERE c.article = :article")
    List<Chain> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Chain c WHERE c.chainElementNumber = :chainElementNumber")
    List<Chain> findByChainElementNumber(@Param("chainElementNumber") ChainElementNumber chainElementNumber, Pageable pageable);

    @Query("SELECT c FROM Chain c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Chain> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

