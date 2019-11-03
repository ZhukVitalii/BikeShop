package beetle.repository.handlebars;

import beetle.entity.Manufacturer;
import beetle.entity.handlebars.Headset;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */
public interface HeadsetRepository extends JpaRepository<Headset, Long> {
    @Query("SELECT c FROM Headset c WHERE c.manufacturer = :manufacturer")
    List<Headset> findByHandlebarMakers(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Headset c WHERE c.manufacturer = :manufacturer")
    long countByHandlebarMaker(@Param("manufacturer") Manufacturer manufacturer);

    @Query("SELECT c FROM Headset c WHERE c.url = :url")
    List<Headset> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Headset c WHERE c.article = :article")
    List<Headset> findByArticle(@Param("article") Long article, Pageable pageable);
}