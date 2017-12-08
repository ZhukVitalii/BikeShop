package beetle.Repositories.Transmission;

import beetle.Entities.Transmission.*;
import beetle.Entities.Wheels.BearingType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
public interface BracketRepository extends JpaRepository<Bracket, Long> {

    @Query("SELECT c FROM Bracket c WHERE c.maker = :maker")
    List<Bracket> findByTransmissionMakers(@Param("maker") TransmissionMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Bracket c WHERE c.maker = :maker")
    long countByTransmissionMakers(@Param("maker")  TransmissionMaker maker);

    @Query("SELECT c FROM Bracket c WHERE c.bracketAxisLength = :bracketAxisLength")
    List<Bracket> findByBracketAxisLength(@Param("bracketAxisLength") BracketAxisLength bracketAxisLength, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE c.bracketWide = :bracketWide")
    List<Bracket> findByBracketWide(@Param("bracketWide") BracketWide bracketWide, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE c.url = :url")
    List<Bracket> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE c.article = :article")
    List<Bracket> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE c.article = :article")
    Bracket findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM Bracket c WHERE c.bracketType = :bracketType")
    List<Bracket> findByBracketType(@Param("bracketType") BracketType bracketType, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE c.bearingType = :bearingType")
    List<Bracket> findByBearingType(@Param("bearingType") BearingType bearingType, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE c.carvingType = :carvingType")
    List<Bracket> findByCarvingType(@Param("carvingType") CarvingType carvingType, Pageable pageable);

    @Query("SELECT c FROM Bracket c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Bracket> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

