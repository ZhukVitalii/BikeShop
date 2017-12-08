package beetle.Repositories.Handlebars;

import beetle.Entities.Forks.TubeDiameter;
import beetle.Entities.Handlebars.HandlebarDiameter;
import beetle.Entities.Handlebars.HandlebarMaker;
import beetle.Entities.Handlebars.Stem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.06.2017.
 */
public interface StemRepository extends JpaRepository<Stem, Long> {
    @Query("SELECT c FROM Stem c WHERE c.maker = :maker")
    List<Stem> findByHandlebarMakers(@Param("maker") HandlebarMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Stem c WHERE c.maker = :maker")
    long countByHandlebarMaker(@Param("maker") HandlebarMaker maker);

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