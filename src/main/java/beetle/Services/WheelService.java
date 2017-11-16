package beetle.Services;

import beetle.Entities.Forks.BrakesType;
import beetle.Entities.Forks.WheelsDiam;
import beetle.Entities.Frames.BikeType;
import beetle.Entities.Wheels.*;
import beetle.Repositories.Frames.BikeTypeRepository;
import beetle.Repositories.Forks.BrakesTypeRepository;
import beetle.Repositories.Forks.WheelsDiamRepository;
import beetle.Repositories.Wheels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Service
public class WheelService {

    //main components

    @Autowired
    private WheelRepository wheelRepository;
    @Autowired
    private SpokeRepository spokeRepository;
    @Autowired
    private RimRepository rimRepository;
    @Autowired
    private FrontHubRepository frontHubRepository;
    @Autowired
    private BackHubRepository backHubRepository;
    @Autowired
    private  TireRepository tireRepository;

    //auxiliary components

    @Autowired
    private RimWideRepository rimWideRepository;
    @Autowired
    private SpokeNumberRepository spokeNumberRepository;
    @Autowired
    private WheelMakerRepository wheelMakerRepository;
    @Autowired
    private BrakesTypeRepository brakesTypeRepository;
    @Autowired
    private WheelsDiamRepository wheelsDiamRepository;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;
    @Autowired
    private ETRTOSizeRepository etrtoSizeRepository;
    @Autowired
    private InnerTubeDiameterRepository innerTubeDiameterRepository;
    @Autowired
    private RimHeightRepository rimHeightRepository;
    @Autowired
    private NippleRepository nippleRepository;
    @Autowired
    private AxisLengthRepository axisLengthRepository;
    @Autowired
    private AxisDiamRepository axisDiamRepository;
    @Autowired
    private BackSprocketTypeRepository backSprocketTypeRepository;
    @Autowired
    private BackSprocketNumberRepository backSprocketNumberRepository;
    @Autowired
    private BearingTypeRepository bearingTypeRepository;
    @Autowired
    private  HubFixTypeRepository hubFixTypeRepository;
    @Autowired
    private RotorFixTypeRepository rotorFixTypeRepository;
    @Autowired
    private TireTypeRepository tireTypeRepository;
    @Autowired
    private CordTypeRepository cordTypeRepository;
    @Autowired
    private TireWideRepository tireWideRepository;

    //Lists with articles of components, that user added to cart

    public List<Long> articlesBackHub = new ArrayList<>();
    public List<Long> articlesFrontHub = new ArrayList<>();
    public List<Long> articlesRim = new ArrayList<>();
    public List<Long> articlesSpoke = new ArrayList<>();
    public List<Long> articlesTire = new ArrayList<>();
    public List<Long> articlesWheel = new ArrayList<>();


    //For backHub

    //add articles to List
    public void addToArticleBackHub(Long article) {
        articlesBackHub.add(article);
        getSizeBackHub();
    }

    //get article from List
    public Long getArticleBackHubFromCart (int a) {
        Long b = articlesBackHub.get(a);
        return b;
    }

    //get size of List
    public int getSizeBackHub() {
        int a = articlesBackHub.size();
        return a;
    }

    //get all articles
    public List<Long> getArticlesBackHub(){
        return articlesBackHub;
    }

    //delete article BackHub
    public void deleteArticleBackHub(long article){
        articlesBackHub.remove(article);
    }


    //For FrontHub
    public void addToArticleFrontHub(Long article) {
        articlesFrontHub.add(article);
        getSizeFrontHub();;
    }

    public Long getArticleFrontHubFromCart (int a) {
        Long b = articlesFrontHub.get(a);
        return b;
    }

    public int getSizeFrontHub() {
        int a = articlesFrontHub.size();
        return a;
    }

    //get all articles
    public List<Long> getArticlesFrontHub(){
        return articlesFrontHub;
    }

    //delete article FrontHub
    public void deleteArticleFrontHub(long article){
        articlesFrontHub.remove(article);
    }

    //For Rim
    public void addToArticleRim(Long article) {
        articlesRim.add(article);
        getSizeRim();;
    }

    public Long getArticleRimFromCart (int a) {
        Long b = articlesRim.get(a);
        return b;
    }

    public int getSizeRim() {
        int a = articlesRim.size();
        return a;
    }

    //get all articles
    public List<Long> getArticlesRim(){
        return articlesRim;
    }

    //delete article Rim
    public void deleteArticleRim(long article){
        articlesRim.remove(article);
    }


    //For Spoke
    public void addToArticleSpoke(Long article) {
        articlesSpoke.add(article);
        getSizeSpoke();
    }

    public Long getArticleSpokeFromCart (int a) {
        Long b = articlesSpoke.get(a);
        return b;
    }

    public int getSizeSpoke() {
        int a = articlesSpoke.size();
        return a;
    }

    //get all articles
    public List<Long> getArticlesSpoke(){
        return articlesSpoke;
    }

    //delete article Spoke
    public void deleteArticleSpoke(long article){
        articlesSpoke.remove(article);
    }


    //For Tire
    public void addToArticleTire(Long article) {
        articlesTire.add(article);
        getSizeTire();
    }

    public Long getArticleTireFromCart (int a) {
        Long b = articlesTire.get(a);
        return b;
    }

    public int getSizeTire() {
        int a = articlesTire.size();
        return a;
    }

    //get all articles
    public List<Long> getArticlesTire(){
        return articlesTire;
    }

    //delete article Tire
    public void deleteArticleTire(long article){
        articlesTire.remove(article);
    }



    //For Wheel
    public void addToArticleWheel(Long article) {
        articlesWheel.add(article);
        getSizeWheel();
    }

    public Long getArticleWheelFromCart (int a) {
        Long b = articlesWheel.get(a);
        return b;
    }

    public int getSizeWheel() {
        int a = articlesWheel.size();
        return a;
    }

    //get all articles
    public List<Long> getArticlesWheel(){
        return articlesWheel;
    }

    //delete article Wheel
    public void deleteArticleWheel(long article){
        articlesWheel.remove(article);
    }

    // add
    @Transactional
    public void addWheel(Wheel wheel) {
        wheelRepository.save(wheel);
    }

    @Transactional
    public  void addSpoke (Spoke spoke) {
        spokeRepository.save(spoke);
    }

    @Transactional
    public  void addRim (Rim rim) {
        rimRepository.save(rim);
    }

    @Transactional
    public  void addFrontHub (FrontHub frontHub) {
        frontHubRepository.save(frontHub);
    }

    @Transactional
    public  void addBackHub (BackHub backHub) {
        backHubRepository.save(backHub);
    }

    @Transactional
    public  void addTire (Tire tire) {
        tireRepository.save(tire);
    }

    @Transactional
    public  void addWheelMaker (WheelMaker wheelMaker) {
        wheelMakerRepository.save(wheelMaker);
    }

    @Transactional
    public  void addSpokeNumber(SpokeNumber spokeNumber) {
        spokeNumberRepository.save(spokeNumber);
    }

    @Transactional
    public  void addRimWide (RimWide rimWide) {
        rimWideRepository.save(rimWide);
    }

    @Transactional
    public void addBrakesType(BrakesType brakesType) {
        brakesTypeRepository.save(brakesType);
    }

    @Transactional
    public void addWheelsDiam(WheelsDiam wheelsDiam) {
        wheelsDiamRepository.save(wheelsDiam);
    }

    @Transactional
    public void addBikeType(BikeType bikeType) {
        bikeTypeRepository.save(bikeType);
    }

    @Transactional
    public  void addEtrtoSize (EtrtoSize etrtoSize) {
        etrtoSizeRepository.save(etrtoSize);
    }

    @Transactional
    public  void addInnerTubeDiameter(InnerTubeDiameter innerTubeDiameter) {
        innerTubeDiameterRepository.save(innerTubeDiameter);
    }

    @Transactional
    public  void addRimHeight (RimHeight rimHeight) {
        rimHeightRepository.save(rimHeight);
    }
    @Transactional
    public void addNipple (Nipple nipple) {
        nippleRepository.save(nipple);
    }

    @Transactional
    public void addAxisLength (AxisLength axisLength) {
        axisLengthRepository.save(axisLength);
    }

    @Transactional
    public void addAxisDiam(AxisDiam axisDiam) {
        axisDiamRepository.save(axisDiam);
    }

    @Transactional
    public void addBackSprocketType(BackSprocketType backSprocketType) {
        backSprocketTypeRepository.save(backSprocketType);
    }

    @Transactional
    public void addBackSprocketNumber(BackSprocketNumber backSprocketNumber) {
        backSprocketNumberRepository.save(backSprocketNumber);
    }

    @Transactional
    public void addBearingType(BearingType bearingType) {
        bearingTypeRepository.save(bearingType);
    }

    @Transactional
    public void addHubFixType(HubFixType hubFixType) {
        hubFixTypeRepository.save(hubFixType);
    }

    @Transactional
    public void addRotorFixType(RotorFixType rotorFixType) {
        rotorFixTypeRepository.save(rotorFixType);
    }

    @Transactional
    public void addCordType(CordType cordType) {
        cordTypeRepository.save(cordType);
    }

    @Transactional
    public void addTireType(TireType tireType) {
        tireTypeRepository.save(tireType);
    }

    @Transactional
    public void addTireWide(TireWide tireWide) {
        tireWideRepository.save(tireWide);
    }

    //delete component from database for admin

    @Transactional
    public void deleteWheel(long[] idList) {
        for (long id : idList)
            wheelRepository.delete(id);
    }

    @Transactional
    public void deleteSpoke(long[] idList) {
        for (long id : idList)
            spokeRepository.delete(id);
    }

    @Transactional
    public void deleteRim(long[] idList) {
        for (long id : idList)
            rimRepository.delete(id);
    }

    @Transactional
    public void deleteFrontHub(long[] idList) {
        for (long id : idList)
            frontHubRepository.delete(id);
    }

    @Transactional
    public void deleteBackHub(long[] idList) {
        for (long id : idList)
            backHubRepository.delete(id);
    }

    @Transactional
    public void deleteTire(long[] idList) {
        for (long id : idList)
            tireRepository.delete(id);
    }

    //find all components from database

    @Transactional(readOnly=true)
    public List<Wheel> findAll(Pageable pageable) {
        return wheelRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Spoke> findAllOne(Pageable pageable) {
        return spokeRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Rim> findAllTwo(Pageable pageable) {
        return rimRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findAllThree(Pageable pageable) {
        return frontHubRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<BackHub> findAllFor(Pageable pageable) {
        return backHubRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Tire> findAllFive(Pageable pageable) {
        return tireRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<WheelMaker> findWheelMakers() {
        return wheelMakerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<WheelsDiam> findWheelsDiam() {
        return wheelsDiamRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<SpokeNumber> findSpokeNumber() {
        return spokeNumberRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<RimWide> findRimWide() {
        return rimWideRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<EtrtoSize> findEtrtoSize() {
        return etrtoSizeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<InnerTubeDiameter> findInnerTubeDiameter() {
        return innerTubeDiameterRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<RimHeight> findRimHeight() {
        return rimHeightRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BrakesType> findBrakesType() {
        return brakesTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Nipple> findNipple() {
        return nippleRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<AxisDiam> findAxisDiam() {
        return axisDiamRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<AxisLength> findAxisLength() {
        return axisLengthRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BackSprocketType> findBackSprocketType() {
        return backSprocketTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BackSprocketNumber> findBackSprocketNumber() {
        return backSprocketNumberRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BearingType> findBearingType() {
        return bearingTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<HubFixType> findHubFixType() {
        return hubFixTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<RotorFixType> findRotorFixType() {
        return rotorFixTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<TireType> findTireType() {
        return tireTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<CordType> findCordType() {
        return cordTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<TireWide> findTireWide() {
        return tireWideRepository.findAll();
    }

    //select from database by parametrs

    @Transactional(readOnly=true)
    public List<Wheel> findByWheelMakers(WheelMaker wheelMaker, Pageable pageable) {
        return wheelRepository.findByWheelMakers(wheelMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Spoke> findBySpokeMaker(WheelMaker wheelMaker, Pageable pageable) {
        return spokeRepository.findByWheelMakers(wheelMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByRimMaker(WheelMaker wheelMaker, Pageable pageable) {
        return rimRepository.findByWheelMakers(wheelMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByFrontHubMaker(WheelMaker wheelMaker, Pageable pageable) {
        return frontHubRepository.findByWheelMakers(wheelMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByBackHubMaker(WheelMaker wheelMaker, Pageable pageable) {
        return backHubRepository.findByWheelMakers(wheelMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findByTireMaker(WheelMaker wheelMaker, Pageable pageable) {
        return tireRepository.findByWheelMakers(wheelMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Wheel> findBySpokeNumber(SpokeNumber spokeNumber, Pageable pageable) {
        return wheelRepository.findBySpokeNumber(spokeNumber, pageable);
    }

    @Transactional(readOnly = true)
    public List<Wheel> findByRimWide(RimWide rimWide, Pageable pegeable) {
        return  wheelRepository.findByRimWide(rimWide, pegeable);
    }

    @Transactional(readOnly=true)
    public List<Wheel> findWheelByArticle(Long article, Pageable pageable) {
        return wheelRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Wheel> findWheelByUrl(String url, Pageable pageable) {
        return wheelRepository.findByUrl(url, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findBackHubByArticle(Long article, Pageable pageable) {
        return backHubRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findBackHubByUrl(String url, Pageable pageable) {
        return backHubRepository.findByUrl(url, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findFrontHubByArticle(Long article, Pageable pageable) {
        return frontHubRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findFrontHubByUrl(String url, Pageable pageable) {
        return frontHubRepository.findByUrl(url, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findRimByArticle(Long article, Pageable pageable) {
        return rimRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Rim> findRimByUrl(String url, Pageable pageable) {
        return rimRepository.findByUrl(url, pageable);
    }

    @Transactional(readOnly=true)
    public List<Spoke> findSpokeByArticle(Long article, Pageable pageable) {
        return spokeRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Spoke> findSpokeByUrl(String url, Pageable pageable) {
        return spokeRepository.findByUrl(url, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findTireByArticle(Long article, Pageable pageable) {
        return tireRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findTireByUrl(String url, Pageable pageable) {
        return tireRepository.findByUrl(url, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByBikeTypeRim(BikeType bikeType, Pageable pageable) {
        return rimRepository.findByBikeType(bikeType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByWheelsDiamRim(WheelsDiam wheelsDiam, Pageable pageable) {
        return rimRepository.findByWheelsDiam(wheelsDiam, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByEtrtoSize(EtrtoSize etrtoSize, Pageable pageable) {
        return rimRepository.findByEtrtoSize(etrtoSize, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findBySpokeNumberRim(SpokeNumber spokeNumber, Pageable pageable) {
        return rimRepository.findBySpokeNumber(spokeNumber, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByInnerTubeDiam(InnerTubeDiameter innerTubeDiameter, Pageable pageable) {
        return rimRepository.findByInnerTubeDiameter(innerTubeDiameter, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByRimWideRim(RimWide rimWide, Pageable pageable) {
        return rimRepository.findByRimWide(rimWide, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByRimHeight(RimHeight rimHeight, Pageable pageable) {
        return rimRepository.findByRimHeight(rimHeight, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByBrakesTypeRim(BrakesType brakesType, Pageable pageable) {
        return rimRepository.findByBrakesType(brakesType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByNipple(Nipple nipple, Pageable pageable) {
        return rimRepository.findByNipple(nipple, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByFrontHubFixType(HubFixType hubFixType, Pageable pageable) {
        return frontHubRepository.findByHubFixType(hubFixType, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByBearingTypeFront(BearingType bearingType, Pageable pageable) {
        return frontHubRepository.findByBearingType(bearingType, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByAxisLengthFrontHub(AxisLength axisLength, Pageable pageable) {
        return frontHubRepository.findByAxisLength(axisLength, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByAxisDiamFrontHub(AxisDiam axisDiam, Pageable pageable) {
        return frontHubRepository.findByAxisDiam(axisDiam, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByBrakesTypeFrontHub(BrakesType brakesType, Pageable pageable) {
        return frontHubRepository.findByBrakesType(brakesType, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByRotorFixeTypeFrontHub(RotorFixType rotorFixType, Pageable pageable) {
        return frontHubRepository.findByRotorFixeType(rotorFixType, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findBySpokeNumberFrontHub(SpokeNumber spokeNumber, Pageable pageable) {
        return frontHubRepository.findBySpokeNumber(spokeNumber, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByBackHubFixType(HubFixType hubFixType, Pageable pageable) {
        return backHubRepository.findByHubFixType(hubFixType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByBearingTypeBackHub(BearingType bearingType, Pageable pageable) {
        return backHubRepository.findByBearingType(bearingType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByAxisLengthBackHub(AxisLength axisLength, Pageable pageable) {
        return backHubRepository.findByAxisLength(axisLength, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByAxisDiamBackHub(AxisDiam axisDiam, Pageable pageable) {
        return backHubRepository.findByAxisDiam(axisDiam, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByBrakesTypeBackHub(BrakesType brakesType, Pageable pageable) {
        return backHubRepository.findByBrakesType(brakesType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByRotorFixeTypeBackHub(RotorFixType rotorFixType, Pageable pageable) {
        return backHubRepository.findByRotorFixeType(rotorFixType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findBySpokeNumberBackHub(SpokeNumber spokeNumber, Pageable pageable) {
        return backHubRepository.findBySpokeNumber(spokeNumber, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByBackSprocketType(BackSprocketType backSprocketType, Pageable pageable) {
        return backHubRepository.findByBackSprocketType(backSprocketType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByBackSprocketNumber(BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return backHubRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findByWheelsDiamTire(WheelsDiam wheelsDiam, Pageable pageable) {
        return tireRepository.findByWheelsDiam(wheelsDiam, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findByCordType(CordType cordType, Pageable pageable) {
        return tireRepository.findByCordType(cordType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findByTireType(TireType tireType, Pageable pageable) {
        return tireRepository.findByTireType(tireType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Tire> findByTireWide(TireWide tireWide, Pageable pageable) {
        return tireRepository.findByTireWide(tireWide, pageable);
    }

    @Transactional(readOnly=true)
    public List<Wheel> findByPattern(String pattern, Pageable pageable) {
        return wheelRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<Spoke> findByPatternSpoke(String pattern, Pageable pageable) {
        return spokeRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<Rim> findByPatternRim(String pattern, Pageable pageable) {
        return  rimRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<FrontHub> findByPatternFromtHub(String pattern, Pageable pageable) {
        return  frontHubRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackHub> findByPatternBackHub(String pattern, Pageable pageable) {
        return  backHubRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<Wheel> findByTypeAndWhDiamAndBrType(BikeType bikeType, WheelsDiam wheelsDiam,BrakesType brakesType, Pageable pageable) {
        return wheelRepository.findByTypeAndWhDiamAndBrType(bikeType, wheelsDiam, brakesType, pageable);
    }

    // count by

    @Transactional(readOnly = true)
    public long countByWheelMaker(WheelMaker wheelMaker) {
        return wheelRepository.countByWheelMakers(wheelMaker);
    }

    @Transactional(readOnly = true)
    public long countByWheelMakerSpoke(WheelMaker wheelMaker) {
        return spokeRepository.countByWheelMakers(wheelMaker);
    }

    @Transactional(readOnly = true)
    public long countByWheelMakerRim(WheelMaker wheelMaker) {
        return rimRepository.countByWheelMakers(wheelMaker);
    }

    @Transactional(readOnly = true)
    public long countByWheelMakerFrontHub(WheelMaker wheelMaker) {
        return frontHubRepository.countByWheelMakers(wheelMaker);
    }

    @Transactional(readOnly = true)
    public long countByWheelMakerBackHub(WheelMaker wheelMaker) {
        return backHubRepository.countByWheelMakers(wheelMaker);
    }

    @Transactional(readOnly = true)
    public long countByWheelMakerTire(WheelMaker wheelMaker) {
        return tireRepository.countByWheelMakers(wheelMaker);
    }

    @Transactional(readOnly = true)
    public long count() {
        return wheelRepository.count();
    }

    @Transactional(readOnly = true)
    public long countSpoke() {
        return spokeRepository.count();
    }

    @Transactional(readOnly = true)
    public long countRim() {
        return rimRepository.count();
    }

    @Transactional(readOnly = true)
    public long countFrontHub() {
        return frontHubRepository.count();
    }

    @Transactional(readOnly = true)
    public long countBackHub() {
        return backHubRepository.count();
    }

    @Transactional(readOnly = true)
    public long countTire() {
        return tireRepository.count();
    }

    //find by id and article
    @Transactional(readOnly = true)
    public BackHub findBackHub(Long id) {return backHubRepository.findOne(id);}

    @Transactional(readOnly = true)
    public BackHub findBackHubByArticle(Long article) {return backHubRepository.findOneByArticle(article);}

    @Transactional(readOnly = true)
    public FrontHub findFrontHub(Long id) {return frontHubRepository.findOne(id);}

    @Transactional(readOnly = true)
    public FrontHub findFrontHubByArticle(Long article) {return frontHubRepository.findOneByArticle(article);}

    @Transactional(readOnly = true)
    public Rim findRim(Long id) {return rimRepository.findOne(id);}

    @Transactional(readOnly = true)
    public Rim findRimByArticle(Long article) {return rimRepository.findOneByArticle(article);}

    @Transactional(readOnly = true)
    public Spoke findSpoke(Long id) {return spokeRepository.findOne(id);}

    @Transactional(readOnly = true)
    public Spoke findSpokeByArticle(Long article) {return spokeRepository.findOneByArticle(article);}

    @Transactional(readOnly = true)
    public Tire findTire(Long id) {return tireRepository.findOne(id);}

    @Transactional(readOnly = true)
    public Tire findTireByArticle(Long article) {return tireRepository.findOneByArticle(article);}

    @Transactional(readOnly = true)
    public Wheel findWheel(Long id) {return wheelRepository.findOne(id);}

    @Transactional(readOnly = true)
    public Wheel findWheelByArticle(Long article) {return wheelRepository.findOneByArticle(article);}

    @Transactional(readOnly=true)
    public WheelMaker findWheelMaker(long id) {
        return wheelMakerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public SpokeNumber findSpokeNumber(long id) {
        return spokeNumberRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public RimWide findRimWide(long id) {
        return rimWideRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public WheelsDiam findWheelsDiam(long id) {
        return wheelsDiamRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public EtrtoSize findEtrtoSize(long id) {
        return etrtoSizeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public InnerTubeDiameter findInnerTubeDiameter(long id) {
        return innerTubeDiameterRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public RimHeight findRimHeight(long id) {
        return rimHeightRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BrakesType findBrakesType(long id) {
        return brakesTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public Nipple findNipple(long id) {
        return nippleRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public AxisLength findAxisLength(long id) {
        return axisLengthRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public AxisDiam findAxisDiam(long id) {
        return axisDiamRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BackSprocketNumber findBackSprocketNumber(long id) {
        return backSprocketNumberRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BackSprocketType findBackSprocketType(long id) {
        return backSprocketTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BearingType findBearingType(long id) {
        return bearingTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public HubFixType findHubFixType(long id) {
        return hubFixTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public RotorFixType findRotorFixType(long id) {
        return rotorFixTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public TireType findTireType(long id) {
        return tireTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public CordType findCordType(long id) {
        return cordTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public TireWide findTireWide(long id) {
        return tireWideRepository.findOne(id);
    }

}