package beetle.Handlebars;

import beetle.Forks.Fork;
import beetle.Forks.TubeDiameter;
import beetle.Transmissions.BackDerailleur;
import beetle.Transmissions.BackSprocketMax;
import beetle.Transmissions.BackSprocketMin;
import beetle.Wheels.BackSprocketNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.06.2017.
 */
public interface StemRepository extends JpaRepository<Stem, Long> {
    @Query("SELECT c FROM Stem c WHERE c.handlebarMaker = :handlebarMaker")
    List<Stem> findByHandlebarMakers(@Param("handlebarMaker") HandlebarMaker handlebarMaker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Stem c WHERE c.handlebarMaker = :handlebarMaker")
    long countByHandlebarMaker(@Param("handlebarMaker") HandlebarMaker handlebarMaker);

    @Query("SELECT c FROM Stem c WHERE c.url = :url")
    List<Stem> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Stem c WHERE c.article = :article")
    List<Stem> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Stem c WHERE c.article = :article")
    Stem findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM Stem c WHERE c.handlebarDiameter = :handlebarDiameter AND c.tubeDiameter = :tubeDiameter ")
    List<Stem> findByHandlebarDiamAndTubeDiam(@Param("handlebarDiameter" ) HandlebarDiameter handlebarDiameter,
                                          @Param("tubeDiameter")TubeDiameter tubeDiameter,
                                          Pageable pageable);

}