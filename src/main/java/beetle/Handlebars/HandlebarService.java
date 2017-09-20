package beetle.Handlebars;

import beetle.Bakes.BikeType;
import beetle.Bakes.BikeTypeRepository;
import beetle.Forks.TubeDiameter;
import beetle.Forks.TubeDiameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Service
public class HandlebarService {
    @Autowired
    private HandlebarRepository handlebarRepository;
    @Autowired
    private WindingRepository windingRepository;
    @Autowired
    private GripsRepository gripsRepository;
    @Autowired
    private HeadsetRepository headsetRepository;
    @Autowired
    private StemRepository stemRepository;

    @Autowired
    private HandlebarDiameterRepository handlebarDiameterRepository ;

    @Autowired
    private HandlebarMakerRepository handlebarMakerRepository ;

    @Autowired
    private HeadsetTypeRepository headsetTypeRepository ;
    @Autowired
    private TubeDiameterRepository tubeDiameterRepository;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;


    public List<Long> articlesHandlebar = new ArrayList<>();
    public List<Long> articlesStem = new ArrayList<>();
    public List<Long> articlesGrips = new ArrayList<>();
    public List<Long> articlesHeadset = new ArrayList<>();
    public List<Long> articlesWinding = new ArrayList<>();

//For handlebar
    public void testPrintHandlebar(){
        for (Long articlo : articlesHandlebar){
            System.out.println(articlo);
        }
    }
    public  void printSizeHandlebar(){
        System.out.println("розмір корзини " + getSizeHandlebar());
    }

    public void addToArticleHandlebar(Long article) {
        articlesHandlebar.add(article);
        testPrintHandlebar();
        getSizeHandlebar();
        printSizeHandlebar();
    }
    public Long getArticleHandlebarFromCart (int a) {
        Long b = articlesHandlebar.get(a);
        return b;
    }
    public int getSizeHandlebar() {
        int a = articlesHandlebar.size();
        return a;
    }
    //For stem
    public void testPrintStem(){
        for (Long articlo : articlesStem){
            System.out.println(articlo);
        }
    }
    public  void printSizeStem(){
        System.out.println("розмір корзини " + getSizeStem());
    }

    public void addToArticleStem(Long article) {
        articlesStem.add(article);
        testPrintStem();
        getSizeStem();
        printSizeStem();
    }
    public Long getArticleStemFromCart (int a) {
        Long b = articlesStem.get(a);
        return b;
    }
    public int getSizeStem() {
        int a = articlesStem.size();
        return a;
    }
    //For grips
    public void testPrintGrips(){
        for (Long articlo : articlesGrips){
            System.out.println(articlo);
        }
    }
    public  void printSizeGrips(){
        System.out.println("розмір корзини " + getSizeGrips());
    }

    public void addToArticleGrips(Long article) {
        articlesGrips.add(article);
        testPrintGrips();
        getSizeGrips();
        printSizeGrips();
    }
    public Long getArticleGripsFromCart (int a) {
        Long b = articlesGrips.get(a);
        return b;
    }
    public int getSizeGrips() {
        int a = articlesGrips.size();
        return a;
    }
    //For headset
    public void testPrintHeadset(){
        for (Long articlo : articlesHeadset){
            System.out.println(articlo);
        }
    }
    public  void printSizeHeadset(){
        System.out.println("розмір корзини " + getSizeHeadset());
    }

    public void addToArticleHeadset(Long article) {
        articlesHeadset.add(article);
        testPrintHeadset();
        getSizeHeadset();
        printSizeHeadset();
    }
    public Long getArticleHeadsetFromCart (int a) {
        Long b = articlesHeadset.get(a);
        return b;
    }
    public int getSizeHeadset() {
        int a = articlesHeadset.size();
        return a;
    }
    //For winding
    public void testPrintWinding(){
        for (Long articlo : articlesWinding){
            System.out.println(articlo);
        }
    }
    public  void printSizeWinding(){
        System.out.println("розмір корзини " + getSizeWinding());
    }

    public void addToArticleWinding(Long article) {
        articlesWinding.add(article);
        testPrintWinding();
        getSizeWinding();
        printSizeWinding();
    }
    public Long getArticleWindingFromCart (int a) {
        Long b = articlesWinding.get(a);
        return b;
    }
    public int getSizeWinding() {
        int a = articlesWinding.size();
        return a;
    }

    @Transactional
    public void addHandlebar(Handlebar handlebar) {
        handlebarRepository.save(handlebar);
    }

    @Transactional
    public  void addWinding (Winding winding) {
        windingRepository.save(winding);
    }
    @Transactional
    public  void addGrips (Grips grips) {
        gripsRepository.save(grips);
    }
    @Transactional
    public  void addHeadset (Headset headset) {
        headsetRepository.save(headset);
    }

    @Transactional
    public  void addStem (Stem stem) {
        stemRepository.save(stem);
    }

    @Transactional
    public void addHandlebarMaker(HandlebarMaker handlebarMaker) {
        handlebarMakerRepository.save(handlebarMaker);
    }
    @Transactional
    public void addHandlebarDiameter(HandlebarDiameter handlebarDiameter) {
        handlebarDiameterRepository.save(handlebarDiameter);
    }


    @Transactional
    public void addBikeType(BikeType bikeType) {
        bikeTypeRepository.save(bikeType);
    }

    @Transactional
    public void addTubeDiameter(TubeDiameter tubeDiameter) {
        tubeDiameterRepository.save(tubeDiameter);
    }

    @Transactional
    public void addHeadsetType(HeadsetType headsetType) {
        headsetTypeRepository.save(headsetType);
    }



    @Transactional
    public void deleteHandlebar(long[] idList) {
        for (long id : idList)
            handlebarRepository.delete(id);
    }
    @Transactional
    public void deleteWinding(long[] idList) {
        for (long id : idList)
            windingRepository.delete(id);
    }


    @Transactional
    public void deleteGrips(long[] idList) {
        for (long id : idList)
            gripsRepository.delete(id);
    }

    @Transactional
    public void deleteHeadset(long[] idList) {
        for (long id : idList)
            headsetRepository.delete(id);
    }

    @Transactional
    public void deleteStem(long[] idList) {
        for (long id : idList)
            stemRepository.delete(id);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findAll(Pageable pageable) {
        return handlebarRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<Winding> findAllTwo(Pageable pageable) {
        return windingRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Grips> findAllThree(Pageable pageable) {
        return gripsRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Headset> findAllFor(Pageable pageable) {
        return headsetRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Stem> findAllFive(Pageable pageable) {
        return stemRepository.findAll(pageable).getContent();
    }



    @Transactional(readOnly=true)
    public List<HandlebarMaker> findHandlebarMakers() {
        return handlebarMakerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findHandlebarByArticle(Long article, Pageable pageable) {
        return handlebarRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Handlebar> findHandlebarByUrl(String url, Pageable pageable) {
        return handlebarRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Stem> findStemByArticle(Long article, Pageable pageable) {
        return stemRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Stem> findStemByUrl(String url, Pageable pageable) {
        return stemRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Grips> findGripsByArticle(Long article, Pageable pageable) {
        return gripsRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Grips> findGripsByUrl(String url, Pageable pageable) {
        return gripsRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Headset> findHeadsetByArticle(Long article, Pageable pageable) {
        return headsetRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Headset> findHeadsetByUrl(String url, Pageable pageable) {
        return headsetRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Winding> findWindingByArticle(Long article, Pageable pageable) {
        return windingRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Winding> findWindingByUrl(String url, Pageable pageable) {
        return windingRepository.findByUrl(url,pageable);
    }



    @Transactional(readOnly=true)
    public List<BikeType> findBikeType() {
        return bikeTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<HandlebarDiameter> findHandlebarDiameter() {
        return handlebarDiameterRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<HeadsetType> findHeadsetType() {
        return headsetTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findByHandlebarMakers(HandlebarMaker handlebarMaker, Pageable pageable) {
        return handlebarRepository.findByHandlebarMakers(handlebarMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Winding> findByHandlebarMaker(HandlebarMaker handlebarMaker, Pageable pageable) {
        return windingRepository.findByHandlebarMakers(handlebarMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Grips> findByHandlebarMakerGrips(HandlebarMaker handlebarMaker, Pageable pageable) {
        return gripsRepository.findByHandlebarMakers(handlebarMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Headset> findByHandlebarMakerHeadset(HandlebarMaker handlebarMaker, Pageable pageable) {
        return headsetRepository.findByHandlebarMakers(handlebarMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Stem> findByHandlebarStem(HandlebarMaker handlebarMaker, Pageable pageable) {
        return stemRepository.findByHandlebarMakers(handlebarMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findByHandlebarDiameter(HandlebarDiameter handlebarDiameter, Pageable pageable) {
        return handlebarRepository.findByHandlebarDiameter(handlebarDiameter, pageable);
    }
    @Transactional(readOnly = true)
    public List<Handlebar> findByBikeType(BikeType bikeType, Pageable pegeable) {
        return  handlebarRepository.findByBikeType(bikeType, pegeable);
    }




    @Transactional(readOnly = true)
    public long countByHandlebarMaker(HandlebarMaker handlebarMaker) {
        return handlebarRepository.countByHandlebarMaker(handlebarMaker);
    }

    @Transactional(readOnly = true)
    public long countByBikeType(BikeType bikeType) {
        return handlebarRepository.countByBikeType(bikeType);
    }

    @Transactional(readOnly = true)
    public long countByHandlebarDiameter(HandlebarDiameter handlebarDiameter) {
        return handlebarRepository.countByHandlebarDiameter(handlebarDiameter);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findByPattern(String pattern, Pageable pageable) {
        return handlebarRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly = true)
    public long count() {
        return handlebarRepository.count();
    }

    @Transactional(readOnly=true)
    public HandlebarMaker findHandlebarMaker(long id) {
        return handlebarMakerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public HandlebarDiameter findHandlebarDiameter(long id) {
        return handlebarDiameterRepository.findOne(id);
    }


    @Transactional(readOnly=true)
    public HeadsetType findHeadsetType(long id) {
        return headsetTypeRepository.findOne(id);
    }

}

