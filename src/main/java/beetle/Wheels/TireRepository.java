package beetle.Wheels;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Forks.WheelsDiam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 25.06.2017.
 */
public interface TireRepository extends JpaRepository<Tire, Long> {
    @Query("SELECT c FROM Tire c WHERE c.wheelMaker = :wheelMaker")
    List<Tire> findByWheelMakers(@Param("wheelMaker") WheelMaker wheelMaker, Pageable pageable);

    @Query("SELECT c FROM Tire c WHERE c.wheelsDiam = :wheelsDiam")
    List<Tire> findByWheelsDiam(@Param("wheelsDiam")WheelsDiam wheelsDiam, Pageable pageable);

    @Query("SELECT c FROM Tire c WHERE c.tireType = :tireType")
    List<Tire> findByTireType(@Param("tireType")TireType tireType, Pageable pageable);

    @Query("SELECT c FROM Tire c WHERE c.cordType = :cordType")
    List<Tire> findByCordType(@Param("cordType")CordType cordType, Pageable pageable);

    @Query("SELECT c FROM Tire c WHERE c.tireWide = :tireWide")
    List<Tire> findByTireWide(@Param("tireWide")TireWide tireWide, Pageable pageable);

    @Query("SELECT c FROM Tire c WHERE c.url = :url")
    List<Tire> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Tire c WHERE c.article = :article")
    List<Tire> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Tire c WHERE c.wheelMaker = :wheelMaker")
    long countByWheelMakers(@Param("wheelMaker")  WheelMaker wheelMaker);

    @Query("SELECT c FROM Tire c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Tire> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

