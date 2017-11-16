package beetle.Services;

import beetle.Entities.Forks.TubeDiameter;
import beetle.Entities.Handlebars.*;
import beetle.Repositories.Forks.TubeDiameterRepository;
import beetle.Entities.Frames.BikeType;
import beetle.Repositories.Frames.BikeTypeRepository;
import beetle.Repositories.Handlebars.*;
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

    //Lists with articles of components, that user added to cart
    public List<Long> articlesHandlebar = new ArrayList<>();
    public List<Long> articlesStem = new ArrayList<>();
    public List<Long> articlesGrips = new ArrayList<>();
    public List<Long> articlesHeadset = new ArrayList<>();
    public List<Long> articlesWinding = new ArrayList<>();





    //For handlebar
    //add articles to List
    public void addToArticleHandlebar(Long article) {
        articlesHandlebar.add(article);
        getSizeHandlebar();
    }
    //get article from List
    public Long getArticleHandlebarFromCart (int a) {
        Long b = articlesHandlebar.get(a);
        return b;
    }
    //get size of List
    public int getSizeHandlebar() {
        int a = articlesHandlebar.size();
        return a;
    }
    //get all articles
    public List<Long> getArticlesHandlebar(){
        return articlesHandlebar;
    }
    //delete articles Handlebar from cart
    public void deleteArticleHandlebar(long article){
        articlesHandlebar.remove(article);
    }

    //For stem

    //add articles to List
    public void addToArticleStem(Long article) {
        articlesStem.add(article);
        getSizeStem();
    }
    //get article from List
    public Long getArticleStemFromCart (int a) {
        Long b = articlesStem.get(a);
        return b;
    }
    //get size of List
    public int getSizeStem() {
        int a = articlesStem.size();
        return a;
    }
    //get all articles
    public List<Long> getArticlesStem(){
        return articlesStem;
    }
    //delete articles Stem from cart
    public void deleteArticleStem(long article){
        articlesStem.remove(article);
    }

    //For grips
    //add articles to List
    public void addToArticleGrips(Long article) {
        articlesGrips.add(article);
        getSizeGrips();
    }
    //get article from List
    public Long getArticleGripsFromCart (int a) {
        Long b = articlesGrips.get(a);
        return b;
    }
    //get size of List
    public int getSizeGrips() {
        int a = articlesGrips.size();
        return a;
    }
    //get all articles
    public List<Long> getArticlesGrips(){
        return articlesGrips;
    }
    //delete articles Grips from cart
    public void deleteArticleGrips(long article){
        articlesGrips.remove(article);
    }


    //For headset
    //add articles to List
    public void addToArticleHeadset(Long article) {
        articlesHeadset.add(article);
        getSizeHeadset();
    }
    //get article from List
    public Long getArticleHeadsetFromCart (int a) {
        Long b = articlesHeadset.get(a);
        return b;
    }
    //get size of List
    public int getSizeHeadset() {
        int a = articlesHeadset.size();
        return a;
    }
    //get all articles
    public List<Long> getArticlesHeadset(){
        return articlesHeadset;
    }

    //delete articles Headset from cart
    public void deleteArticleHeadset(long article){
        articlesHeadset.remove(article);
    }

    //For winding
    //add articles to List
    public void addToArticleWinding(Long article) {
        articlesWinding.add(article);
        getSizeWinding();
    }
    //get article from List
    public Long getArticleWindingFromCart (int a) {
        Long b = articlesWinding.get(a);
        return b;
    }
    //get size of List
    public int getSizeWinding() {
        int a = articlesWinding.size();
        return a;
    }
    //get all articles
    public List<Long> getArticlesWinding(){
        return articlesWinding;
    }
    //delete articles Winding from cart
    public void deleteArticleWinding(long article){
        articlesWinding.remove(article);
    }
    //  add

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


    //delete component from database for admin

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

    //find all components from database

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

    //select from database by parametrs

    @Transactional(readOnly=true)
    public List<Stem> findByHandlebarDiamAndTubeDiam(HandlebarDiameter handlebarDiameter,
                                                     TubeDiameter tubeDiameter,
                                                     Pageable pageable) {
        return stemRepository.findByHandlebarDiamAndTubeDiam(handlebarDiameter,
                                                             tubeDiameter,
                                                             pageable);
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

    @Transactional(readOnly=true)
    public List<Handlebar> findByPattern(String pattern, Pageable pageable) {
        return handlebarRepository.findByPattern(pattern, pageable);
    }

    // count by

    @Transactional(readOnly = true)
    public long countByHandlebarMaker(HandlebarMaker handlebarMaker) {
        return handlebarRepository.countByHandlebarMaker(handlebarMaker);
    }

    @Transactional(readOnly = true)
    public long count() {
        return handlebarRepository.count();
    }


    //find by id
    @Transactional(readOnly = true)
    public Handlebar findHandlebar(long id) {
        return handlebarRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Handlebar findHandlebarByArticle(Long article) {return handlebarRepository.findOneByArticle(article);}


    @Transactional(readOnly = true)
    public Stem findStem(long id) {
        return stemRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Stem findStemByArticle(Long article) {return stemRepository.findOneByArticle(article);}


    @Transactional(readOnly = true)
    public Grips findGrips(long id) {
        return gripsRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Grips findGripsByArticle(Long article) {return gripsRepository.findOneByArticle(article);}

    @Transactional(readOnly = true)
    public Headset findHeadset(long id) {
        return headsetRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Headset findHeadsetByArticle(Long article) {return headsetRepository.findOneByArticle(article);}


    @Transactional (readOnly = true)
    public Winding findWinding(long id) {
        return windingRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Winding findWindingByArticle(Long article) {return windingRepository.findOneByArticle(article);}


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

