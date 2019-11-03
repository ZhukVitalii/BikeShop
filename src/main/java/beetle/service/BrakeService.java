package beetle.service;

import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HandlebarDiameter;
import beetle.entity.wheels.RotorFixType;
import beetle.entity.brake.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrakeService {
    void addToArticleBrakeDiscHydraulic(Long article);

    Long getArticleBrakeDiscHydraulicFromCart (int a);

    int getSizeBrakeDiscHydraulic();

    void addToArticleBrakeDiscMechanik(Long article);

    Long getArticleBrakeDiscMechanikFromCart (int a);

    int getSizeBrakeDiscMechanik();

    void addToArticleBrakeVBrake(Long article);

    Long getArticleBrakeVBrakeFromCart (int a);

    int getSizeBrakeVBrake();

    void addToArticleBrakeHandle(Long article);

    Long getArticleBrakeHandleFromCart (int a);

    int getSizeBrakeHandle();

    void addBrakeDiscHydraulic(BrakeDiscHydraulic brakeDiscHydraulic);

    void addBrakeDiscMechanik (BrakeDiscMechanik brakeDiscMechanik);

    void addBrakeVBrake (BrakeVBrake brakeVBrake);

    void addBrakeHandle (BrakeHandle brakeHandle);

    void addBrakeMaker (Manufacturer brakeMaker);

    void addBrakeHandleCompatibility(BrakeHandleCompatibility brakeHandleCompatibility);

    void addBrakeHandleLocation (BrakeHandleLocation brakeHandleLocation);

    void addBrakeHandleWide(BrakeHandleWide brakeHandleWide);

    void addBrakeLiquid(BrakeLiquid brakeLiquid);

    void addLengthHydroline(LengthHydroline lengthHydroline);

    void addLocation(Location location);

    void addRotorDiam (RotorDiam rotorDiam);

    void deleteBrakeDiscHydraulic(long[] idList);

    void deleteBrakeDiscMechanik(long[] idList);

    void deleteBrakeVBrake(long[] idList);

    void deleteBrakeHandle(long[] idList);

    List<BrakeDiscHydraulic> findAll(Pageable pageable);

    List<BrakeDiscMechanik> findAllOne(Pageable pageable);

    List<BrakeVBrake> findAllTwo(Pageable pageable);

    List<BrakeHandle> findAllThree(Pageable pageable);

    List<Manufacturer> findBrakeMakers();

    List<BrakeHandleCompatibility> findBrakeHandleCompatibility();

    List<Location> findLocation();

    List<BrakeHandleLocation> findBrakeHandleLocation();

    List<BrakeHandleWide> findBrakeHandleWide();

    List<BrakeLiquid> findBrakeLiquid();

    List<LengthHydroline> findLengthHydroline();

    List<RotorDiam> findRotorDiam();

    List<BrakeDiscHydraulic> findByBrakeDiscHydraulicMakers(Manufacturer brakeMaker, Pageable pageable);

    List<BrakeDiscMechanik> findByBrakeDiscMechanikMakers(Manufacturer brakeMaker, Pageable pageable);

    List<BrakeVBrake> findByBrakeVBrakeMakers(Manufacturer brakeMaker, Pageable pageable);

    List<BrakeHandle> findByBrakeHandleMakers(Manufacturer brakeMaker, Pageable pageable);

    List<BrakeDiscHydraulic> findBrakeDiscHydraulicByArticle(Long article, Pageable pageable);

    List<BrakeDiscHydraulic> findBrakeDiscHydraulicByUrl(String url, Pageable pageable);

    List<BrakeDiscMechanik> findBrakeDiscMechanikByArticle(Long article, Pageable pageable);

    List<BrakeDiscMechanik> findBrakeDiscMechanikByUrl(String url, Pageable pageable);

    List<BrakeVBrake> findBrakeVBrakeByArticle(Long article, Pageable pageable) ;

    List<BrakeVBrake> findBrakeVBrakeByUrl(String url, Pageable pageable) ;

    List<BrakeHandle> findBrakeHandleByArticle(Long article, Pageable pageable);

    List<BrakeHandle> findBrakeHandleByUrl(String url, Pageable pageable);

    List<BrakeDiscHydraulic> findByLocationHydraulic(Location location, Pageable pageable);

    List<BrakeDiscHydraulic> findByLengthHydroline(LengthHydroline lengthHydroline, Pageable pageable);

    List<BrakeDiscHydraulic> findByBrakeLiquid(BrakeLiquid brakeLiquid, Pageable pageable);

    List<BrakeDiscHydraulic> findByRotorDiam(RotorDiam rotorDiam, Pageable pageable);

    List<BrakeDiscHydraulic> findByRotorFixType(RotorFixType rotorFixType, Pageable pageable);

    List<BrakeDiscMechanik> findByLocationMechanik(Location location, Pageable pageable);

    List<BrakeDiscMechanik> findByRotorDiamMechanik(RotorDiam rotorDiam, Pageable pageable);

    List<BrakeDiscMechanik> findByRotorFixTypeMechanik(RotorFixType rotorFixType, Pageable pageable);

    List<BrakeVBrake> findByLocationVBrake(Location location, Pageable pageable);

    List<BrakeHandle> findByBrakeHandleLocation(BrakeHandleLocation brakeHandleLocation, Pageable pageable);

    List<BrakeHandle> findByBrakeHandleCompatibility (BrakeHandleCompatibility brakeHandleCompatibility, Pageable pageable);

    List<BrakeHandle> findByHandlebarDiameter (HandlebarDiameter handlebarDiameter, Pageable pageable);

    List<BrakeHandle> findByBrakeHandleWide (BrakeHandleWide brakeHandleWide, Pageable pageable);

    List<BrakeDiscHydraulic> findByPatternDiscHydr(String pattern, Pageable pageable);

    List<BrakeDiscMechanik> findByPatternDiscMech(String pattern, Pageable pageable);

    List<BrakeVBrake> findByPatternVBrake(String pattern, Pageable pageable);

    List<BrakeHandle> findByPatternBrakeHandle(String pattern, Pageable pageable);

    long countByBrakeMakerDiscHydr(Manufacturer brakeMaker);

    long countByBrakeMakerDiscMech(Manufacturer brakeMaker);

    long countByBrakeMakerVBrake(Manufacturer brakeMaker);

    long countByBrakeMakerHandle(Manufacturer brakeMaker);

    long countBrakeDiscHydr();

    long countBrakeDiscMech();

    long countVBrake();

    long countBrakeHandle();

    Manufacturer findBrakeMaker(long id);

    Location findLication(long id);

    BrakeHandleCompatibility findBrakeHandleCompatibility(long id);

    BrakeHandleLocation findBrakeHandleLocation(long id);

    BrakeHandleWide findBrakeHandleWide(long id);

    BrakeLiquid findBrakeLiquid(long id);

    LengthHydroline  findLengthHydroline(long id);

    RotorDiam  findRotorDiam(long id);
}
