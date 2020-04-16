package beetle.service.impl;

import beetle.bo.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.forks.Fork;
import beetle.json.fork.ForkSearchInputJSON;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.ForkRepository;
import beetle.repository.forks.TubeDiameterRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.service.ForkService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class ForkServiceImpl implements ForkService {
    private final ForkRepository forkRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final TubeDiameterRepository tubeDiameterRepository ;
    private final WheelsDiamRepository wheelsDiamRepository ;
    private final BikeTypeRepository bikeTypeRepository;
    private final SessionFactory sessionFactory;

    @Autowired
    public ForkServiceImpl(ForkRepository forkRepository, ManufacturerRepository manufacturerRepository,
                           TubeDiameterRepository tubeDiameterRepository, WheelsDiamRepository wheelsDiamRepository,
                           BikeTypeRepository bikeTypeRepository, SessionFactory sessionFactory) {
        this.forkRepository = forkRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.tubeDiameterRepository = tubeDiameterRepository;
        this.wheelsDiamRepository = wheelsDiamRepository;
        this.bikeTypeRepository = bikeTypeRepository;
        this.sessionFactory = sessionFactory;
    }

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


    @Override
    @Transactional(readOnly = true)
    public SearchResultBO searchByCriteria(ForkSearchInputJSON input){
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Fork.class);
        if (input.getBikeTypeId() != null)
            searchCriteria.add(Restrictions.eq("bikeType",bikeTypeRepository.getOne(input.getBikeTypeId())));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if(input.getBrakeType() != null)
            searchCriteria.add(Restrictions.eq("brakeType", input.getBrakeType()));
        if(input.getTubeDiameterId() != null)
            searchCriteria.add(Restrictions.eq("tubeDiameter", tubeDiameterRepository.findOne(input.getTubeDiameterId())));
        if(input.getWheelsDiamId() != null)
            searchCriteria.add(Restrictions.eq("wheelsDiam", wheelsDiamRepository.findOne(input.getWheelsDiamId())));
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
    @Override
    @Transactional(readOnly = true)
    public Fork findFork(Long id) {
        return forkRepository.findOne(id);
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

    @Transactional(readOnly=true)
    public List<Fork> findAll(Pageable pageable) {
        return forkRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Fork> findByPattern(String pattern, Pageable pageable) {
        return forkRepository.findByPattern(pattern, pageable);
    }
    @Transactional(readOnly = true)
    public long count() {
        return forkRepository.count();
    }




}
