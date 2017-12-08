package beetle.Repositories.Handlebars;

import beetle.Entities.Frames.BikeType;
import beetle.Entities.Handlebars.Handlebar;
import beetle.Entities.Handlebars.HandlebarDiameter;
import beetle.Entities.Handlebars.HandlebarMaker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
public interface HandlebarRepository extends JpaRepository<Handlebar, Long> {

    @Query("SELECT c FROM Handlebar c WHERE c.maker = :maker")
    List<Handlebar> findByHandlebarMakers(@Param("maker") HandlebarMaker maker, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.handlebarDiameter = :handlebarDiameter")
    List<Handlebar> findByHandlebarDiameter(@Param("handlebarDiameter") HandlebarDiameter handlebarDiameter, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.url = :url")
    List<Handlebar> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.article = :article")
    List<Handlebar> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.article = :article")
    Handlebar findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM Handlebar c WHERE c.bikeType = :bikeType")
    List<Handlebar> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Handlebar> findByPattern(@Param("pattern") String pattern, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Handlebar c WHERE c.maker = :maker")
    long countByHandlebarMaker(@Param("maker") HandlebarMaker maker);


}
