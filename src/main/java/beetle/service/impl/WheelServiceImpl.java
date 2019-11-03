package beetle.service.impl;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.*;
import beetle.service.WheelService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelServiceImpl implements WheelService{
    @Override
    public void addToArticleBackHub(Long article) {

    }

    @Override
    public Long getArticleBackHubFromCart(int a) {
        return null;
    }

    @Override
    public int getSizeBackHub() {
        return 0;
    }

    @Override
    public void addToArticleFrontHub(Long article) {

    }

    @Override
    public Long getArticleFrontHubFromCart(int a) {
        return null;
    }

    @Override
    public int getSizeFrontHub() {
        return 0;
    }

    @Override
    public void addToArticleRim(Long article) {

    }

    @Override
    public Long getArticleRimFromCart(int a) {
        return null;
    }

    @Override
    public int getSizeRim() {
        return 0;
    }

    @Override
    public void addToArticleSpoke(Long article) {

    }

    @Override
    public Long getArticleSpokeFromCart(int a) {
        return null;
    }

    @Override
    public int getSizeSpoke() {
        return 0;
    }

    @Override
    public void addToArticleTire(Long article) {

    }

    @Override
    public Long getArticleTireFromCart(int a) {
        return null;
    }

    @Override
    public int getSizeTire() {
        return 0;
    }

    @Override
    public void addToArticleWheel(Long article) {

    }

    @Override
    public Long getArticleWheelFromCart(int a) {
        return null;
    }

    @Override
    public int getSizeWheel() {
        return 0;
    }

    @Override
    public void addWheel(Wheel wheel) {

    }

    @Override
    public void addSpoke(Spoke spoke) {

    }

    @Override
    public void addRim(Rim rim) {

    }

    @Override
    public void addFrontHub(FrontHub frontHub) {

    }

    @Override
    public void addBackHub(BackHub backHub) {

    }

    @Override
    public void addTire(Tire tire) {

    }

    @Override
    public void addWheelMaker(Manufacturer wheelMaker) {

    }

    @Override
    public void deleteWheel(long[] idList) {

    }

    @Override
    public void deleteSpoke(long[] idList) {

    }

    @Override
    public void deleteRim(long[] idList) {

    }

    @Override
    public void deleteFrontHub(long[] idList) {

    }

    @Override
    public void deleteBackHub(long[] idList) {

    }

    @Override
    public void deleteTire(long[] idList) {

    }

    @Override
    public List<Wheel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Spoke> findAllOne(Pageable pageable) {
        return null;
    }

    @Override
    public List<Rim> findAllTwo(Pageable pageable) {
        return null;
    }

    @Override
    public List<FrontHub> findAllThree(Pageable pageable) {
        return null;
    }

    @Override
    public List<BackHub> findAllFor(Pageable pageable) {
        return null;
    }

    @Override
    public List<Tire> findAllFive(Pageable pageable) {
        return null;
    }

    @Override
    public List<Manufacturer> findWheelMakers() {
        return null;
    }

    @Override
    public List<SpokeNumber> findSpokeNumber() {
        return null;
    }

    @Override
    public List<RimWide> findRimWide() {
        return null;
    }

    @Override
    public List<EtrtoSize> findEtrtoSize() {
        return null;
    }

    @Override
    public List<InnerTubeDiameter> findInnerTubeDiameter() {
        return null;
    }

    @Override
    public List<RimHeight> findRimHeight() {
        return null;
    }

    @Override
    public List<Nipple> findNipple() {
        return null;
    }

    @Override
    public List<AxisDiam> findAxisDiam() {
        return null;
    }

    @Override
    public List<AxisLength> findAxisLength() {
        return null;
    }

    @Override
    public List<BackSprocketType> findBackSprocketType() {
        return null;
    }

    @Override
    public List<BackSprocketNumber> findBackSprocketNumber() {
        return null;
    }

    @Override
    public List<BearingType> findBearingType() {
        return null;
    }

    @Override
    public List<HubFixType> findHubFixType() {
        return null;
    }

    @Override
    public List<RotorFixType> findRotorFixType() {
        return null;
    }

    @Override
    public List<TireType> findTireType() {
        return null;
    }

    @Override
    public List<CordType> findCordType() {
        return null;
    }

    @Override
    public List<TireWide> findTireWide() {
        return null;
    }

    @Override
    public List<Wheel> findByWheelMakers(Manufacturer wheelMaker, Pageable pageable) {
        return null;
    }

    @Override
    public List<Spoke> findBySpokeMaker(Manufacturer wheelMaker, Pageable pageable) {
        return null;
    }

    @Override
    public List<Rim> findByRimMaker(Manufacturer wheelMaker, Pageable pageable) {
        return null;
    }

    @Override
    public List<FrontHub> findByFrontHubMaker(Manufacturer wheelMaker, Pageable pageable) {
        return null;
    }

    @Override
    public List<BackHub> findByBackHubMaker(Manufacturer wheelMaker, Pageable pageable) {
        return null;
    }

    @Override
    public List<Tire> findByTireMaker(Manufacturer wheelMaker, Pageable pageable) {
        return null;
    }

    @Override
    public List<Wheel> findWheelByArticle(Long article, Pageable pageable) {
        return null;
    }

    @Override
    public List<Wheel> findWheelByUrl(String url, Pageable pageable) {
        return null;
    }

    @Override
    public List<BackHub> findBackHubByArticle(Long article, Pageable pageable) {
        return null;
    }

    @Override
    public List<BackHub> findBackHubByUrl(String url, Pageable pageable) {
        return null;
    }

    @Override
    public List<FrontHub> findFrontHubByArticle(Long article, Pageable pageable) {
        return null;
    }

    @Override
    public List<FrontHub> findFrontHubByUrl(String url, Pageable pageable) {
        return null;
    }

    @Override
    public List<Rim> findRimByArticle(Long article, Pageable pageable) {
        return null;
    }

    @Override
    public List<Rim> findRimByUrl(String url, Pageable pageable) {
        return null;
    }

    @Override
    public List<Spoke> findSpokeByArticle(Long article, Pageable pageable) {
        return null;
    }

    @Override
    public List<Spoke> findSpokeByUrl(String url, Pageable pageable) {
        return null;
    }

    @Override
    public List<Tire> findTireByArticle(Long article, Pageable pageable) {
        return null;
    }

    @Override
    public List<Tire> findTireByUrl(String url, Pageable pageable) {
        return null;
    }

    @Override
    public List<Wheel> findByPattern(String pattern, Pageable pageable) {
        return null;
    }

    @Override
    public List<Wheel> findByTypeAndWhDiamAndBrType(BikeType bikeType, WheelsDiam wheelsDiam, BrakesType brakesType, Pageable pageable) {
        return null;
    }

    @Override
    public long countByWheelMaker(Manufacturer wheelMaker) {
        return 0;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public long countSpoke() {
        return 0;
    }

    @Override
    public long countRim() {
        return 0;
    }

    @Override
    public long countFrontHub() {
        return 0;
    }

    @Override
    public long countBackHub() {
        return 0;
    }

    @Override
    public long countTire() {
        return 0;
    }

    @Override
    public Manufacturer findWheelMaker(long id) {
        return null;
    }

    @Override
    public SpokeNumber findSpokeNumber(long id) {
        return null;
    }

    @Override
    public RimWide findRimWide(long id) {
        return null;
    }

    @Override
    public BikeType findBikeType(long id) {
        return null;
    }

    @Override
    public EtrtoSize findEtrtoSize(long id) {
        return null;
    }

    @Override
    public InnerTubeDiameter findInnerTubeDiameter(long id) {
        return null;
    }

    @Override
    public RimHeight findRimHeight(long id) {
        return null;
    }

    @Override
    public Nipple findNipple(long id) {
        return null;
    }

    @Override
    public AxisLength findAxisLength(long id) {
        return null;
    }

    @Override
    public AxisDiam findAxisDiam(long id) {
        return null;
    }

    @Override
    public BackSprocketNumber findBackSprocketNumber(long id) {
        return null;
    }

    @Override
    public BackSprocketType findBackSprocketType(long id) {
        return null;
    }

    @Override
    public BearingType findBearingType(long id) {
        return null;
    }

    @Override
    public HubFixType findHubFixType(long id) {
        return null;
    }

    @Override
    public RotorFixType findRotorFixType(long id) {
        return null;
    }

    @Override
    public TireType findTireType(long id) {
        return null;
    }

    @Override
    public CordType findCordType(long id) {
        return null;
    }

    @Override
    public TireWide findTireWide(long id) {
        return null;
    }
}
