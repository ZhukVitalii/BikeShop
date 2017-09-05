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


    public List<Long> articles = new ArrayList<>();


    public void testPrint(){
        for (Long articlo : articles){
            System.out.println(articlo);
        }
    }
    public  void printSize(){
        System.out.println("розмір корзини " + getSize());
    }


    public void addToArticle(Long article) {
        articles.add(article);
        testPrint();
        getSize();
        printSize();
    }
    public Long getArticleFromCart (int a) {
        Long b = articles.get(a);
        return b;
    }
    public int getSize() {
        int a = articles.size();
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
    public List<Handlebar> findByArticle(Long article, Pageable pageable) {
        return handlebarRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Handlebar> findByUrl(String url, Pageable pageable) {
        return handlebarRepository.findByUrl(url,pageable);
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

