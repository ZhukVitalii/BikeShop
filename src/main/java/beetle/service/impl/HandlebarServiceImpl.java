package beetle.service.impl;

import beetle.bo.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.handlebars.*;
import beetle.json.handlebar.HandlebarSearchInputJSON;
import beetle.repository.ManufacturerRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.repository.handlebars.*;
import beetle.service.HandlebarService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class HandlebarServiceImpl  implements HandlebarService {
    private final HandlebarRepository handlebarRepository;
    private final WindingRepository windingRepository;
    private final GripsRepository gripsRepository;
    private final HeadsetRepository headsetRepository;
    private final StemRepository stemRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final HeadsetTypeRepository headsetTypeRepository ;
    private final BikeTypeRepository bikeTypeRepository;
    private final SessionFactory sessionFactory;

    public HandlebarServiceImpl(HandlebarRepository handlebarRepository, WindingRepository windingRepository,
                                GripsRepository gripsRepository, HeadsetRepository headsetRepository,
                                StemRepository stemRepository, ManufacturerRepository manufacturerRepository,
                                HeadsetTypeRepository headsetTypeRepository, BikeTypeRepository bikeTypeRepository,
                                SessionFactory sessionFactory) {
        this.handlebarRepository = handlebarRepository;
        this.windingRepository = windingRepository;
        this.gripsRepository = gripsRepository;
        this.headsetRepository = headsetRepository;
        this.stemRepository = stemRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.headsetTypeRepository = headsetTypeRepository;
        this.bikeTypeRepository = bikeTypeRepository;
        this.sessionFactory = sessionFactory;
    }

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
    public void addHandlebarMaker(Manufacturer handlebarMaker) {
        manufacturerRepository.save(handlebarMaker);
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
    public List<Manufacturer> findHandlebarMakers() {
        return manufacturerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BikeType> findBikeType() {
        return bikeTypeRepository.findAll();
    }


    @Transactional(readOnly=true)
    public List<HeadsetType> findHeadsetType() {
        return headsetTypeRepository.findAll();
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
    public List<Handlebar> findByHandlebarMakers(Manufacturer handlebarMaker, Pageable pageable) {
        return handlebarRepository.findByHandlebarMakers(handlebarMaker, pageable);
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
    public long countByHandlebarMaker(Manufacturer handlebarMaker) {
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

    @Transactional(readOnly=true)
    public Manufacturer findHandlebarMaker(long id) {
        return manufacturerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public HeadsetType findHeadsetType(long id) {
        return headsetTypeRepository.findOne(id);
    }


    @Override
    @Transactional
    public SearchResultBO searchByCriteria(HandlebarSearchInputJSON input){
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Handlebar.class);
        if (input.getBikeTypeId() != null)
            searchCriteria.add(Restrictions.eq("bikeType",bikeTypeRepository.findOne(input.getBikeTypeId())));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if(input.getHandlebarDiameter() != null)
            searchCriteria.add(Restrictions.eq("handlebarDiameter", input.getHandlebarDiameter()));
        if (input.getHandlebarHeight() != null)
            searchCriteria.add(Restrictions.eq("handlebarHeight", input.getHandlebarHeight()));
        if (input.getHandlebarWide() != null)
            searchCriteria.add(Restrictions.eq("handlebarWide", input.getHandlebarWide()));
        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }

    private Long getCount(Criteria searchCriteria) {
        searchCriteria.setProjection(Projections.rowCount());
        Long count =(Long) searchCriteria.uniqueResult();
        searchCriteria.setProjection(null);
        return count;
    }
}
