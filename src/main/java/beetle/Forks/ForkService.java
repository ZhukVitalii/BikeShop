package beetle.Forks;

import beetle.Frames.BikeType;
import beetle.Frames.BikeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */
@Service
public class ForkService {
    @Autowired
    private ForkRepository forkRepository;

    @Autowired
    private ForkMakerRepository forkMakerRepository ;


    @Autowired
    private TubeDiameterRepository tubeDiameterRepository ;
    @Autowired
    private WheelsDiamRepository wheelsDiamRepository ;
    @Autowired
    private BrakesTypeRepository brakesTypeRepository ;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;

    public List<Long> articles = new ArrayList<>();



    //add articles to List
    public void addToArticle(Long article) {
        articles.add(article);
        getSize();

    }
    //get article from List
    public Long getArticleFromCart (int a) {
        Long b = articles.get(a);
        return b;
    }
    ////get size of List
    public int getSize() {
        int a = articles.size();
        return a;
    }


    // add
    @Transactional
    public void addFork(Fork fork) {
        forkRepository.save(fork);
    }

    @Transactional
    public void addForkMaker(ForkMaker forkMaker) {
        forkMakerRepository.save(forkMaker);
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
    public void addWheelsDiam(WheelsDiam wheelsDiam) {
        wheelsDiamRepository.save(wheelsDiam);
    }

    @Transactional
    public void addBrakesType(BrakesType brakesType) {
        brakesTypeRepository.save(brakesType);
    }

    //delete component from database for admin
    @Transactional
    public void deleteForks(long[] idList) {
        for (long id : idList)
            forkRepository.delete(id);
    }

    //find all components and from database
    @Transactional(readOnly=true)
    public List<ForkMaker> findForkMakers() {
        return forkMakerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Fork> findAll(Pageable pageable) {
        return forkRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<BikeType> findBikeType() {
        return bikeTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<WheelsDiam> findWheelsDiam() {
        return wheelsDiamRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<TubeDiameter> findTubeDiameter() {
        return tubeDiameterRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BrakesType> findBrakesType() {
        return brakesTypeRepository.findAll();
    }

    //select from database by parametrs
    @Transactional(readOnly=true)
    public List<Fork> findByForkMakers(ForkMaker forkMaker, Pageable pageable) {
        return forkRepository.findByForkMakers(forkMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByBikeType(BikeType bikeType, Pageable pageable) {
        return forkRepository.findByBikeType(bikeType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByUrl(String url, Pageable pageable) {
        return forkRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByArticle(Long article, Pageable pageable) {
        return forkRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByTubeDiameter(TubeDiameter tubeDiameter, Pageable pageable) {
        return forkRepository.findByTubeDiameter(tubeDiameter, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByWheelsDiam(WheelsDiam wheelsDiam, Pageable pageable) {
        return forkRepository.findByWheelsDiam(wheelsDiam, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByBrakesType(BrakesType brakesType, Pageable pageable) {
        return forkRepository.findByBrakesType(brakesType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByPattern(String pattern, Pageable pageable) {
        return forkRepository.findByPattern(pattern, pageable);
    }

    // count by
    @Transactional(readOnly = true)
    public long countByForkMaker(ForkMaker forkMaker) {
        return forkRepository.countByForkMaker(forkMaker);
    }

    @Transactional(readOnly = true)
    public long countByBikeType(BikeType bikeType) {
        return forkRepository.countByBikeType(bikeType);
    }

    @Transactional(readOnly = true)
    public long countByTubeDiameter(TubeDiameter tubeDiameter) {
        return forkRepository.countByTubeDiameter(tubeDiameter);
    }

    @Transactional(readOnly = true)
    public long countByWheelsDiam(WheelsDiam wheelsDiam) {
        return forkRepository.countByWheelsDiam(wheelsDiam);
    }

    @Transactional(readOnly = true)
    public long countByBrakesType(BrakesType brakesType) {
        return forkRepository.countByBrakesType(brakesType);
    }

    @Transactional(readOnly = true)
    public long count() {
        return forkRepository.count();
    }

    //Find by id
    @Transactional(readOnly=true)
    public ForkMaker findForkMaker(long id) {
        return forkMakerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public TubeDiameter findTubeDiameter(long id) {
        return tubeDiameterRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public WheelsDiam findWheelsDiam(long id) {
        return wheelsDiamRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BrakesType findBrakesType(long id) {
        return brakesTypeRepository.findOne(id);
    }


}

