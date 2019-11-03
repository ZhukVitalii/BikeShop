package beetle.service.impl;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.Fork;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.BrakesTypeRepository;
import beetle.repository.forks.ForkRepository;
import beetle.repository.forks.TubeDiameterRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.service.ForkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class ForkServiceImpl implements ForkService {
    @Autowired
    private ForkRepository forkRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
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
    public void addForkMaker(Manufacturer forkMaker) {
        manufacturerRepository.save(forkMaker);
    }


    //delete component from database for admin
    @Transactional
    public void deleteForks(long[] idList) {
        for (long id : idList)
            forkRepository.delete(id);
    }

    //find all components and from database
    @Transactional(readOnly=true)
    public List<Manufacturer> findForkMakers() {
        return manufacturerRepository.findAll();
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
    public List<Fork> findByForkMakers(Manufacturer forkMaker, Pageable pageable) {
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
    public List<Fork> findByPattern(String pattern, Pageable pageable) {
        return forkRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<Fork> findByTypeAndWhDiamAndTubeDiamAndBrType(BikeType bikeType, WheelsDiam wheelsDiam,TubeDiameter tubeDiameter, BrakesType brakesType, Pageable pageable) {
        return forkRepository.findByTypeAndWhDiamAndTubeDiamAndBrType(bikeType, wheelsDiam,tubeDiameter,brakesType, pageable);
    }


    // count by
    @Transactional(readOnly = true)
    public long countByForkMaker(Manufacturer forkMaker) {
        return forkRepository.countByForkMaker(forkMaker);
    }


    @Transactional(readOnly = true)
    public long count() {
        return forkRepository.count();
    }

    //Find by id

    @Transactional(readOnly = true)
    public Fork findFork(Long id) {
        return forkRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public Manufacturer findForkMaker(long id) {
        return manufacturerRepository.findOne(id);
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
