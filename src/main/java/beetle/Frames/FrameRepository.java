package beetle.Frames;

import beetle.Bakes.BikeType;
import beetle.Forks.BrakesType;
import beetle.Forks.Fork;
import beetle.Forks.TubeDiameter;
import beetle.Forks.WheelsDiam;
import beetle.Handlebars.HeadsetType;
import beetle.Transmissions.BracketWide;
import beetle.Transmissions.BracketWideRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FrameRepository extends JpaRepository<Frame, Long> {
    @Query("SELECT c FROM Frame c WHERE c.frameMaker = :frameMaker")
    List<Frame> findByFrameMaker(@Param("frameMaker") FrameMaker frameMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.frameMaker = :frameMaker")
    long countByFrameMaker(@Param("frameMaker") FrameMaker frameMaker);

    @Query("SELECT c FROM Frame c WHERE c.url = :url")
    List<Frame> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.article = :article")
    List<Frame> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Frame c WHERE c.bikeType = :bikeType AND c.frameSize = :frameSize")
    List<Frame> findByTypeAndSize(@Param("bikeType" )BikeType bikeType,  @Param("frameSize") FrameSize frameSize,Pageable pageable);








    @Query("SELECT c FROM Frame c WHERE c.frameSize =:frameSize ")
    List<Frame> findBySize(@Param("frameSize")  FrameSize frameSize, Pageable pageable);





    @Query("SELECT c FROM Frame c WHERE c.frameSize = :frameSize")
    List<Frame> findByFrameSize(@Param("frameSize") FrameSize frameSize, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.frameSize = :frameSize")
    long countByFrameSize(@Param("frameSize") FrameSize frameSize);

    @Query("SELECT c FROM Frame c WHERE c.wheelsDiam = :wheelsDiam")
    List<Frame> findByWheelsDiam(@Param("wheelsDiam") WheelsDiam wheelsDiam, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.wheelsDiam = :wheelsDiam")
    long countByWheelsDiam(@Param("wheelsDiam") WheelsDiam wheelsDiam);


    @Query("SELECT c FROM Frame c WHERE c.bikeType = :bikeType")
    List<Frame> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.bikeType = :bikeType")
    long countByBikeType(@Param("bikeType") BikeType bikeType);

    @Query("SELECT c FROM Frame c WHERE c.bracketWide = :bracketWide")
    List<Frame> findByBracketWide(@Param("bracketWide")BracketWide bracketWide, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.bracketWide = :bracketWide")
    long countByBracketWide(@Param("bracketWide") BracketWide bracketWide);

    @Query("SELECT c FROM Frame c WHERE c.headsetType = :headsetType")
    List<Frame> findByHeadsetType(@Param("headsetType") HeadsetType headsetType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.headsetType = :headsetType")
    long countByHeadsetType(@Param("headsetType") HeadsetType headsetType);

    @Query("SELECT c FROM Frame c WHERE c.tubeDiameter = :tubeDiameter")
    List<Frame> findByTubeDiameter(@Param("tubeDiameter")TubeDiameter tubeDiameter, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.tubeDiameter = :tubeDiameter")
    long countByTubeDiameter(@Param("tubeDiameter") TubeDiameter tubeDiameter);

    @Query("SELECT c FROM Frame c WHERE c.underSaddleTube = :underSaddleTube")
    List<Frame> findByUnderSaddleTube(@Param("underSaddleTube")UnderSaddleTube underSaddleTube, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.underSaddleTube = :underSaddleTube")
    long countByUnderSaddleTube(@Param("underSaddleTube") UnderSaddleTube underSaddleTube);

    @Query("SELECT c FROM Frame c WHERE c.brakesType = :brakesType")
    List<Frame> findByBrakesType(@Param("brakesType")BrakesType brakesType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.brakesType = :brakesType")
    long countByBrakesType(@Param("brakesType") BrakesType brakesType);

    @Query("SELECT c FROM Frame c WHERE c.trunkBinding = :trunkBinding")
    List<Frame> findByTrunkBinding(@Param("trunkBinding")TrunkBinding trunkBinding, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Frame c WHERE c.trunkBinding = :trunkBinding")
    long countByTrunkBinding(@Param("trunkBinding") TrunkBinding trunkBinding);



    @Query("SELECT c FROM Frame c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Frame> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
