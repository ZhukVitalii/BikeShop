package beetle.service.impl;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.json.brakes.BrakeHandleSearchInputJSON;
import beetle.json.brakes.BrakeSearchInputJSON;
import beetle.repository.ManufacturerRepository;
import beetle.repository.handlebars.HandlebarDiameterRepository;
import beetle.entity.brake.*;
import beetle.repository.brake.*;
import beetle.service.BrakeService;
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

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Service
public class BrakeServiceImpl implements BrakeService {

    private final BrakeHandleRepository brakeHandleRepository;
    private final BrakeRepository brakeRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final SessionFactory sessionFactory;
    private final HandlebarDiameterRepository handlebarDiameterRepository;

    @Autowired
    public BrakeServiceImpl(BrakeHandleRepository brakeHandleRepository, BrakeRepository brakeRepository,
                            ManufacturerRepository manufacturerRepository, SessionFactory sessionFactory,
                            HandlebarDiameterRepository handlebarDiameterRepository) {
        this.brakeHandleRepository = brakeHandleRepository;
        this.brakeRepository = brakeRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.sessionFactory = sessionFactory;
        this.handlebarDiameterRepository = handlebarDiameterRepository;
    }

    //Lists with articles of components, that user added to cart
    public List<Long> articlesBrakeDiscHydraulic = new ArrayList<>();
    public List<Long> articlesBrakeDiscMechanik = new ArrayList<>();
    public List<Long> articlesBrakeVBrake = new ArrayList<>();
    public List<Long> articlesBrakeHandle = new ArrayList<>();

    //For BrakeDiscHydraulic

    //add articles to List
    public void addToArticleBrakeDiscHydraulic(Long article) {
        articlesBrakeDiscHydraulic.add(article);
        getSizeBrakeDiscHydraulic();
    }
    //get article from List
    public Long getArticleBrakeDiscHydraulicFromCart (int a) {
        Long b = articlesBrakeDiscHydraulic.get(a);
        return b;
    }
    //get size of List
    public int getSizeBrakeDiscHydraulic() {
        int a = articlesBrakeDiscHydraulic.size();
        return a;
    }

    //For BrakeDiscDiscMechanik
    public void addToArticleBrakeDiscMechanik(Long article) {
        articlesBrakeDiscMechanik.add(article);
        getSizeBrakeDiscMechanik();
    }
    public Long getArticleBrakeDiscMechanikFromCart (int a) {
        Long b = articlesBrakeDiscMechanik.get(a);
        return b;
    }
    public int getSizeBrakeDiscMechanik() {
        int a = articlesBrakeDiscMechanik.size();
        return a;
    }

    //For BrakeVBrake
    public void addToArticleBrakeVBrake(Long article) {
        articlesBrakeVBrake.add(article);
        getSizeBrakeVBrake();
    }
    public Long getArticleBrakeVBrakeFromCart (int a) {
        Long b = articlesBrakeVBrake.get(a);
        return b;
    }
    public int getSizeBrakeVBrake() {
        int a = articlesBrakeVBrake.size();
        return a;
    }

    //For BrakeHandle
    public void addToArticleBrakeHandle(Long article) {
        articlesBrakeHandle.add(article);
        getSizeBrakeHandle();
    }
    public Long getArticleBrakeHandleFromCart (int a) {
        Long b = articlesBrakeHandle.get(a);
        return b;
    }
    public int getSizeBrakeHandle() {
        int a = articlesBrakeHandle.size();
        return a;
    }


    @Override
    @Transactional
    public SearchResultBO searchByCriteria(BrakeSearchInputJSON input){
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Brake.class);
        if (input.getBrakeType() != null)
            searchCriteria.add(Restrictions.eq("brakeType",input.getBrakeType()));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if(input.getBrakeSubType() != null)
            searchCriteria.add(Restrictions.eq("brakeSubType", input.getBrakeSubType()));
        if (input.getLocation() != null)
            searchCriteria.add(Restrictions.eq("location", input.getLocation()));
        if (input.getRotorDiam() != null)
            searchCriteria.add(Restrictions.eq("rotorDiam", input.getRotorDiam()));
        if (input.getRotorFixType() != null)
            searchCriteria.add(Restrictions.eq("rotorFixType", input.getRotorFixType()));
        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }
    @Override
    @Transactional
    public SearchResultBO searchByCriteria(BrakeHandleSearchInputJSON input){
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(BrakeHandle.class);
        if (input.getCompatibility() != null)
            searchCriteria.add(Restrictions.eq("compatibility",input.getCompatibility()));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if(input.getHandlebarDiameterId() != null)
            searchCriteria.add(Restrictions.eq("handlebarDiameter",handlebarDiameterRepository.getOne(input.getHandlebarDiameterId())));
        if (input.getLocation() != null)
            searchCriteria.add(Restrictions.eq("location", input.getLocation()));
        if (input.getWide() != null)
            searchCriteria.add(Restrictions.eq("wide", input.getWide()));
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


    // add
    @Override
    @Transactional
    public void addBrake(Brake brake) {
        brakeRepository.save(brake);
    }

    @Transactional
    public  void addBrakeHandle (BrakeHandle brakeHandle) {
        brakeHandleRepository.save(brakeHandle);
    }

    @Transactional
    public  void addBrakeMaker (Manufacturer brakeMaker) {
        manufacturerRepository.save(brakeMaker);
    }


    @Transactional
    public void deleteBrakes(long[] idList) {
        for (long id : idList)
            brakeRepository.delete(id);
    }

    @Transactional
    public void deleteBrakeHandle(long[] idList) {
        for (long id : idList)
            brakeHandleRepository.delete(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Brake> findAllBrakes(Pageable pageable) {
        return brakeRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional(readOnly=true)
    public List<BrakeHandle> findAllHandles(Pageable pageable) {
        return brakeHandleRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional
    public Brake getBrake(Long id){
        return brakeRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Manufacturer> findBrakeMakers() {
        return manufacturerRepository.findAll();
    }

    @Override
    @Transactional
    public BrakeHandle getBrakeHandle(Long id) {
        return brakeHandleRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public long countBrakeHandle() {
        return brakeHandleRepository.count();
    }

    //find by id

    @Transactional(readOnly=true)
    public Manufacturer findBrakeMaker(long id) {
        return manufacturerRepository.findOne(id);
    }

}
