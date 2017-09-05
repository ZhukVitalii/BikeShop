package beetle.Transmissions;

import beetle.Forks.BrakesType;
import beetle.Wheels.*;
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
    @Query("SELECT COUNT(c) FROM BackDerailleur c WHERE c.backSprocketNumber = :backSprocketNumber")
    long countByBackSprocketNumber(@Param("backSprocketNumber")  BackSprocketNumber backSprocketNumber);

    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketMax = :backSprocketMax")
    List<BackDerailleur> findByBackSprocketMax(@Param("backSprocketMax") BackSprocketMax backSprocketMax, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BackDerailleur c WHERE c.backSprocketMax = :backSprocketMax")
    long countByBackSprocketMax(@Param("backSprocketMax")  BackSprocketMax backSprocketMax);


    @Query("SELECT c FROM BackDerailleur c WHERE c.backSprocketMin = :backSprocketMin")
    List<BackDerailleur> findByBackSprocketMin(@Param("backSprocketMin") BackSprocketMin backSprocketMin, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BackDerailleur c WHERE c.backSprocketMin = :backSprocketMin")
    long countByBackSprocketMin(@Param("backSprocketMin")  BackSprocketMin backSprocketMin);


    @Query("SELECT c FROM BackDerailleur c WHERE c.pawLength = :pawLength")
    List<BackDerailleur> findByPawLength(@Param("pawLength") PawLength pawLength, Pageable pageable);
    @Query("SELECT COUNT(c) FROM BackDerailleur c WHERE c.pawLength = :pawLength")
    long countByPawLength(@Param("pawLength")  PawLength pawLength);





    @Query("SELECT c FROM BackDerailleur c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BackDerailleur> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
