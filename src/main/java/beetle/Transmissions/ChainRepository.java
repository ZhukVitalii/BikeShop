package beetle.Transmissions;

import beetle.Wheels.BackSprocketNumber;
import beetle.Wheels.BearingType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface ChainRepository extends JpaRepository<Chain, Long> {

    @Query("SELECT c FROM Chain c WHERE c.transmissionMaker = :transmissionMaker")
    List<Chain> findByTransmissionMakers(@Param("transmissionMaker") TransmissionMaker transmissionMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Chain c WHERE c.transmissionMaker = :transmissionMaker")
    long countByTransmissionMakers(@Param("transmissionMaker")  TransmissionMaker transmissionMaker);

    @Query("SELECT c FROM Chain c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<Chain> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Chain c WHERE c.backSprocketNumber = :backSprocketNumber")
    long countByBackSprocketNumber(@Param("backSprocketNumber")  BackSprocketNumber backSprocketNumber);

    @Query("SELECT c FROM Chain c WHERE c.chainElementNumber = :chainElementNumber")
    List<Chain> findByChainElementNumber(@Param("chainElementNumber") ChainElementNumber chainElementNumber, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Chain c WHERE c.chainElementNumber = :chainElementNumber")
    long countByChainElementNumber(@Param("chainElementNumber")  ChainElementNumber chainElementNumber);








    @Query("SELECT c FROM Chain c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Chain> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

