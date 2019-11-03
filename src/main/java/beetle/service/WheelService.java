package beetle.service;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.*;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.BrakesTypeRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.repository.wheels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */

public interface WheelService {
    void addToArticleBackHub(Long article);

    Long getArticleBackHubFromCart (int a) ;

    int getSizeBackHub() ;

    void addToArticleFrontHub(Long article);

    Long getArticleFrontHubFromCart (int a);

    int getSizeFrontHub() ;

    void addToArticleRim(Long article);

    Long getArticleRimFromCart (int a);

    int getSizeRim();

    void addToArticleSpoke(Long article);

    Long getArticleSpokeFromCart (int a);

    int getSizeSpoke();

    void addToArticleTire(Long article);

    Long getArticleTireFromCart (int a);

    int getSizeTire() ;

    void addToArticleWheel(Long article);

    Long getArticleWheelFromCart (int a);

    int getSizeWheel();

    void addWheel(Wheel wheel);

    void addSpoke (Spoke spoke);

    void addRim (Rim rim);

    void addFrontHub (FrontHub frontHub);

    void addBackHub (BackHub backHub);

    void addTire (Tire tire);

    void addWheelMaker (Manufacturer wheelMaker);

    void deleteWheel(long[] idList);

    void deleteSpoke(long[] idList);

    void deleteRim(long[] idList);

    void deleteFrontHub(long[] idList);

    void deleteBackHub(long[] idList);

    void deleteTire(long[] idList);

    List<Wheel> findAll(Pageable pageable);

    List<Spoke> findAllOne(Pageable pageable);

    List<Rim> findAllTwo(Pageable pageable);

    List<FrontHub> findAllThree(Pageable pageable);

    List<BackHub> findAllFor(Pageable pageable);

    List<Tire> findAllFive(Pageable pageable);

    List<Manufacturer> findWheelMakers();

    List<SpokeNumber> findSpokeNumber();

    List<RimWide> findRimWide();

    List<EtrtoSize> findEtrtoSize();

    List<InnerTubeDiameter> findInnerTubeDiameter();

    List<RimHeight> findRimHeight();

    List<Nipple> findNipple();

    List<AxisDiam> findAxisDiam();

    List<AxisLength> findAxisLength();

    List<BackSprocketType> findBackSprocketType();

    List<BackSprocketNumber> findBackSprocketNumber();

    List<BearingType> findBearingType();

    List<HubFixType> findHubFixType();

    List<RotorFixType> findRotorFixType();

    List<TireType> findTireType();

    List<CordType> findCordType();

    List<TireWide> findTireWide();

    List<Wheel> findByWheelMakers(Manufacturer wheelMaker, Pageable pageable);

    List<Spoke> findBySpokeMaker(Manufacturer wheelMaker, Pageable pageable);

    List<Rim> findByRimMaker(Manufacturer wheelMaker, Pageable pageable) ;

    List<FrontHub> findByFrontHubMaker(Manufacturer wheelMaker, Pageable pageable);

    List<BackHub> findByBackHubMaker(Manufacturer wheelMaker, Pageable pageable);

    List<Tire> findByTireMaker(Manufacturer wheelMaker, Pageable pageable);

    List<Wheel> findWheelByArticle(Long article, Pageable pageable);

    List<Wheel> findWheelByUrl(String url, Pageable pageable) ;

    List<BackHub> findBackHubByArticle(Long article, Pageable pageable);

    List<BackHub> findBackHubByUrl(String url, Pageable pageable);

    List<FrontHub> findFrontHubByArticle(Long article, Pageable pageable);

    List<FrontHub> findFrontHubByUrl(String url, Pageable pageable) ;

    List<Rim> findRimByArticle(Long article, Pageable pageable);

    List<Rim> findRimByUrl(String url, Pageable pageable);

    List<Spoke> findSpokeByArticle(Long article, Pageable pageable);

    List<Spoke> findSpokeByUrl(String url, Pageable pageable) ;

    List<Tire> findTireByArticle(Long article, Pageable pageable) ;

    List<Tire> findTireByUrl(String url, Pageable pageable);


    List<Wheel> findByPattern(String pattern, Pageable pageable);

    List<Wheel> findByTypeAndWhDiamAndBrType(BikeType bikeType, WheelsDiam wheelsDiam,BrakesType brakesType, Pageable pageable);

    long countByWheelMaker(Manufacturer wheelMaker);

    long count();

    long countSpoke();

    long countRim();

    long countFrontHub();

    long countBackHub();

    long countTire();

    Manufacturer findWheelMaker(long id);

    SpokeNumber findSpokeNumber(long id);

    RimWide findRimWide(long id);

    BikeType findBikeType(long id);

    EtrtoSize findEtrtoSize(long id);

    InnerTubeDiameter findInnerTubeDiameter(long id);

    RimHeight findRimHeight(long id);

    Nipple findNipple(long id);

    AxisLength findAxisLength(long id);

    AxisDiam findAxisDiam(long id);

    BackSprocketNumber findBackSprocketNumber(long id);

    BackSprocketType findBackSprocketType(long id);

    BearingType findBearingType(long id);

    HubFixType findHubFixType(long id);

    RotorFixType findRotorFixType(long id);

    TireType findTireType(long id);

    CordType findCordType(long id);

    TireWide findTireWide(long id);

}