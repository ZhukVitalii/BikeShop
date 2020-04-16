package beetle.service;

import beetle.bo.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.handlebars.*;
import beetle.json.handlebar.HandlebarSearchInputJSON;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */

public interface HandlebarService {

    void addToArticleHandlebar(Long article);

    Long getArticleHandlebarFromCart (int a);

    int getSizeHandlebar();

    void addToArticleStem(Long article);

    Long getArticleStemFromCart (int a);

    int getSizeStem();

    void addToArticleGrips(Long article);

    Long getArticleGripsFromCart (int a);

    int getSizeGrips();

    void addToArticleHeadset(Long article);

    Long getArticleHeadsetFromCart (int a);

    int getSizeHeadset();

    void addToArticleWinding(Long article);

    Long getArticleWindingFromCart (int a);

    int getSizeWinding();

    void addHandlebar(Handlebar handlebar);

    void addWinding (Winding winding);

    void addGrips (Grips grips);

    void addHeadset (Headset headset);

    void addStem (Stem stem);

    void addHandlebarMaker(Manufacturer handlebarMaker);

    void deleteHandlebar(long[] idList);

    void deleteWinding(long[] idList);

    void deleteGrips(long[] idList);

    void deleteHeadset(long[] idList);

    void deleteStem(long[] idList);

    List<Handlebar> findAll(Pageable pageable);

    List<Winding> findAllTwo(Pageable pageable);

    List<Grips> findAllThree(Pageable pageable);

    List<Headset> findAllFor(Pageable pageable);

    List<Stem> findAllFive(Pageable pageable);

    List<Manufacturer> findHandlebarMakers();

    List<BikeType> findBikeType();

    List<HeadsetType> findHeadsetType();

    List<Handlebar> findHandlebarByArticle(Long article, Pageable pageable);

    List<Handlebar> findHandlebarByUrl(String url, Pageable pageable);

    List<Stem> findStemByArticle(Long article, Pageable pageable);

    List<Stem> findStemByUrl(String url, Pageable pageable);

    List<Grips> findGripsByArticle(Long article, Pageable pageable);

    List<Grips> findGripsByUrl(String url, Pageable pageable);

    List<Headset> findHeadsetByArticle(Long article, Pageable pageable);

    List<Headset> findHeadsetByUrl(String url, Pageable pageable);

    List<Winding> findWindingByArticle(Long article, Pageable pageable);

    List<Winding> findWindingByUrl(String url, Pageable pageable);

    List<Handlebar> findByHandlebarMakers(Manufacturer handlebarMaker, Pageable pageable);

    List<Handlebar> findByBikeType(BikeType bikeType, Pageable pegeable);

    List<Handlebar> findByPattern(String pattern, Pageable pageable);

    long countByHandlebarMaker(Manufacturer handlebarMaker) ;

    long count();

    Handlebar findHandlebar(long id);

    Manufacturer findHandlebarMaker(long id);

    BikeType findBikeType(long id);

    HeadsetType findHeadsetType(long id);

    SearchResultBO searchByCriteria(HandlebarSearchInputJSON input);
}

