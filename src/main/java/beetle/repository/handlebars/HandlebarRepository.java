package beetle.repository.handlebars;

import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.handlebars.Handlebar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
public interface HandlebarRepository extends JpaRepository<Handlebar, Long> {

    @Query("SELECT c FROM Handlebar c WHERE c.manufacturer = :manufacturer")
    List<Handlebar> findByHandlebarMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.url = :url")
    List<Handlebar> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.article = :article")
    List<Handlebar> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.bikeType = :bikeType")
    List<Handlebar> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Handlebar> findByPattern(@Param("pattern") String pattern, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Handlebar c WHERE c.manufacturer = :manufacturer")
    long countByHandlebarMaker(@Param("manufacturer") Manufacturer manufacturer);


}
