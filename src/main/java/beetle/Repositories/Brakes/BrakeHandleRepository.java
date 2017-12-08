package beetle.Repositories.Brakes;

import beetle.Entities.Brakes.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Entities.Handlebars.HandlebarDiameter;

import java.util.List;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
public interface BrakeHandleRepository extends JpaRepository<BrakeHandle, Long> {

    @Query("SELECT c FROM BrakeHandle c WHERE c.maker = :maker")
    List<BrakeHandle> findByBrakeMakers(@Param("maker") BrakeMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BrakeHandle c WHERE c.maker = :maker")
    long countByBrakeMakers(@Param("maker")  BrakeMaker maker);

    @Query("SELECT c FROM BrakeHandle c WHERE c.brakeHandleLocation = :brakeHandleLocation")
    List<BrakeHandle> findByBrakeHandleLocation(@Param("brakeHandleLocation") BrakeHandleLocation brakeHandleLocation, Pageable pageable);

    @Query("SELECT c FROM BrakeHandle c WHERE c.url = :url")
    List<BrakeHandle> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BrakeHandle c WHERE c.article = :article")
    List<BrakeHandle> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BrakeHandle c WHERE c.article = :article")
    BrakeHandle findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM BrakeHandle c WHERE c.brakeHandleCompatibility = :brakeHandleCompatibility")
    List<BrakeHandle> findByBrakeHandleCompatibility(@Param("brakeHandleCompatibility") BrakeHandleCompatibility brakeHandleCompatibility, Pageable pageable);

    @Query("SELECT c FROM BrakeHandle c WHERE c.handlebarDiameter = :handlebarDiameter")
    List<BrakeHandle> findByHandlebarDiameter(@Param("handlebarDiameter")HandlebarDiameter handlebarDiameter, Pageable pageable);

    @Query("SELECT c FROM BrakeHandle c WHERE c.brakeHandleWide = :brakeHandleWide")
    List<BrakeHandle> findByBrakeHandleWide(@Param("brakeHandleWide")BrakeHandleWide brakeHandleWide, Pageable pageable);


    @Query("SELECT c FROM BrakeHandle c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BrakeHandle> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}

