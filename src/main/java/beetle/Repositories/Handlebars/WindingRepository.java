package beetle.Repositories.Handlebars;

import beetle.Entities.Handlebars.HandlebarMaker;
import beetle.Entities.Handlebars.Winding;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.06.2017.
 */
public interface WindingRepository extends JpaRepository<Winding, Long> {
    @Query("SELECT c FROM Winding c WHERE c.maker = :maker")
    List<Winding> findByHandlebarMakers(@Param("maker") HandlebarMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Winding c WHERE c.maker = :maker")
    long countByHandlebarMaker(@Param("maker") HandlebarMaker maker);

    @Query("SELECT c FROM Winding c WHERE c.url = :url")
    List<Winding> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Winding c WHERE c.article = :article")
    List<Winding> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Winding c WHERE c.article = :article")
    Winding findOneByArticle(@Param("article") Long article);
}