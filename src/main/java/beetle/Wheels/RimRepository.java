package beetle.Wheels;

import beetle.Bakes.BikeType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import beetle.Forks.BrakesType;
import beetle.Forks.WheelsDiam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 14.06.2017.
 */
public interface RimRepository extends JpaRepository<Rim, Long> {
    @Query("SELECT c FROM Rim c WHERE c.wheelMaker = :wheelMaker")
    List<Rim> findByWheelMakers(@Param("wheelMaker") WheelMaker wheelMaker, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.wheelMaker = :wheelMaker")
    long countByWheelMakers(@Param("wheelMaker")  WheelMaker wheelMaker);



    @Query("SELECT c FROM Rim c WHERE c.bikeType = :bikeType")
    List<Rim> findByBikeType (@Param("bikeType")BikeType bikeType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.bikeType = :bikeType")
    long countByBikeType(@Param("bikeType")  BikeType bikeType);

    @Query("SELECT c FROM Rim c WHERE c.wheelsDiam = :wheelsDiam")
    List<Rim> findByWheelsDiam (@Param("wheelsDiam")WheelsDiam wheelsDiam, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.wheelsDiam = :wheelsDiam")
    long countByWheelsDiam(@Param("wheelsDiam")  WheelsDiam wheelsDiam);

    @Query("SELECT c FROM Rim c WHERE c.etrtoSize = :etrtoSize")
    List<Rim> findByEtrtoSize (@Param("etrtoSize")EtrtoSize etrtoSize, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.etrtoSize = :etrtoSize")
    long countByEtrtoSize(@Param("etrtoSize")  EtrtoSize etrtoSize);

    @Query("SELECT c FROM Rim c WHERE c.spokeNumber = :spokeNumber")
    List<Rim> findBySpokeNumber (@Param("spokeNumber")SpokeNumber spokeNumber, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.spokeNumber = :spokeNumber")
    long countBySpokeNumber(@Param("spokeNumber")  SpokeNumber spokeNumber);

    @Query("SELECT c FROM Rim c WHERE c.innerTubeDiameter = :innerTubeDiameter")
    List<Rim> findByInnerTubeDiameter (@Param("innerTubeDiameter")InnerTubeDiameter innerTubeDiameter, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.innerTubeDiameter = :innerTubeDiameter")
    long countByInnerTubeDiameter(@Param("innerTubeDiameter")  InnerTubeDiameter innerTubeDiameter);

    @Query("SELECT c FROM Rim c WHERE c.rimWide = :rimWide")
    List<Rim> findByRimWide (@Param("rimWide")RimWide rimWide, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.rimWide = :rimWide")
    long countByRimWide(@Param("rimWide")  RimWide rimWide);

    @Query("SELECT c FROM Rim c WHERE c.rimHeight = :rimHeight")
    List<Rim> findByRimHeight (@Param("rimHeight")RimHeight rimHeight, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.rimHeight = :rimHeight")
    long countByRimHeight(@Param("rimHeight")  RimHeight rimHeight);

    @Query("SELECT c FROM Rim c WHERE c.brakesType = :brakesType")
    List<Rim> findByBrakesType (@Param("brakesType")BrakesType brakesType, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.brakesType = :brakesType")
    long countByBrakesType(@Param("brakesType")  BrakesType brakesType);

    @Query("SELECT c FROM Rim c WHERE c.nipple = :nipple")
    List<Rim> findByNipple (@Param("nipple")Nipple nipple, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Rim c WHERE c.nipple = :nipple")
    long countByNipple(@Param("nipple") Nipple nipple);





    @Query("SELECT c FROM Rim c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Rim> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}