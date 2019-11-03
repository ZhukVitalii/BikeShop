package beetle.repository.frame;

import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.transmission.BracketWide;
import beetle.entity.frame.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FrameRepository extends JpaRepository<Frame, Long> {


    String sql = "SELECT c FROM Frame c WHERE";

//    @Query("SELECT c FROM Frame c WHERE c.frameMaker = :frameMaker " +
//            "AND c.url = :url " +
//            "AND c.article = :article " +
//            "AND c.bikeType = :bikeType " +
//            "AND c.frameSize = :frameSize " +
//            "AND c.wheelsDiam =:wheelsDiam " +
//            "AND c.bracketWide = :bracketWide " +
//            "AND c.headsetType =:headsetType " +
//            "AND c.tubeDiameter =:tubeDiameter " +
//            "AND c.underSaddleTube =:underSaddleTube " +
//            "AND c.brakesType =:brakesType " +
//            "AND c.trunkBinding =:trunkBinding")
    @Query("SELECT c FROM Frame c WHERE c.bracketWide = :bracketWide")
    List<Frame> findFrame(//@Param("frameMaker") FrameMaker frameMaker,
//                          @Param("url") String url,
//                          @Param("article") Long article,
//                          @Param("bikeType" )BikeType bikeType,
//                          @Param("frameSize") FrameSize frameSize,
//                          @Param("wheelsDiam") WheelsDiam wheelsDiam,
                          @Param("bracketWide")BracketWide bracketWide,
//                          @Param("headsetType") HeadsetType headsetType,
//                          @Param("tubeDiameter")TubeDiameter tubeDiameter,
//                          @Param("underSaddleTube")UnderSaddleTube underSaddleTube,
//                          @Param("brakesType")BrakesType brakesType,
//                          @Param("trunkBinding")TrunkBinding trunkBinding,
                          Pageable pageable);


    @Query("SELECT c FROM Frame c WHERE c.manufacturer = :manufacturer")
    List<Frame> findByFrameMaker(@Param("manufacturer") Manufacturer manufacturer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Frame c WHERE c.manufacturer = :manufacturer")
    long countByFrameMaker(@Param("manufacturer") Manufacturer manufacturer);

    @Query("SELECT c FROM Frame c WHERE c.url = :url")
    List<Frame> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.article = :article")
    List<Frame> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.bikeType = :bikeType AND c.frameSize = :frameSize")
    List<Frame> findByTypeAndSize(@Param("bikeType" )BikeType bikeType,
                                  @Param("frameSize") FrameSize frameSize, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.frameSize =:frameSize ")
    List<Frame> findBySize(@Param("frameSize")  FrameSize frameSize, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.frameSize = :frameSize")
    List<Frame> findByFrameSize(@Param("frameSize") FrameSize frameSize, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.wheelsDiam = :wheelsDiam")
    List<Frame> findByWheelsDiam(@Param("wheelsDiam") WheelsDiam wheelsDiam, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.bikeType = :bikeType")
    List<Frame> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.bikeType = :bikeType")
    long countByBikeType(@Param("bikeType") BikeType bikeType);

    @Query("SELECT c FROM Frame c WHERE c.bracketWide = :bracketWide")
    List<Frame> findByBracketWide(@Param("bracketWide")BracketWide bracketWide, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.headsetType = :headsetType")
    List<Frame> findByHeadsetType(@Param("headsetType") HeadsetType headsetType, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.tubeDiameter = :tubeDiameter")
    List<Frame> findByTubeDiameter(@Param("tubeDiameter")TubeDiameter tubeDiameter, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.underSaddleTube = :underSaddleTube")
    List<Frame> findByUnderSaddleTube(@Param("underSaddleTube")UnderSaddleTube underSaddleTube, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.brakesType = :brakesType")
    List<Frame> findByBrakesType(@Param("brakesType")BrakesType brakesType, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.trunkBinding = :trunkBinding")
    List<Frame> findByTrunkBinding(@Param("trunkBinding")TrunkBinding trunkBinding, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Frame> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
