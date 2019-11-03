package beetle.repository.handlebars;

import beetle.entity.forks.TubeDiameter;
import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HandlebarDiameter;
import beetle.entity.handlebars.Stem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.06.2017.
 */
public interface StemRepository extends JpaRepository<Stem, Long> {
    @Query("SELECT c FROM Stem c WHERE c.manufacturer = :manufacturer")
    List<Stem> findByHandlebarMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Stem c WHERE c.manufacturer = :manufacturer")
    long countByHandlebarMaker(@Param("manufacturer") Manufacturer manufacturer);

    @Query("SELECT c FROM Stem c WHERE c.url = :url")
    List<Stem> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Stem c WHERE c.article = :article")
    List<Stem> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Stem c WHERE c.handlebarDiameter = :handlebarDiameter AND c.tubeDiameter = :tubeDiameter ")
    List<Stem> findByHandlebarDiamAndTubeDiam(@Param("handlebarDiameter" ) HandlebarDiameter handlebarDiameter,
                                          @Param("tubeDiameter")TubeDiameter tubeDiameter,
                                          Pageable pageable);

}