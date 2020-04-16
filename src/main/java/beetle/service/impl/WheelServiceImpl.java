package beetle.service.impl;

import beetle.bo.SearchResultBO;
import beetle.entity.wheels.*;
import beetle.json.wheel.*;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.repository.wheels.*;
import beetle.service.WheelService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WheelServiceImpl implements WheelService{
    private final WheelRepository wheelRepository;
    private final WheelsDiamRepository wheelsDiamRepository ;
    private final SessionFactory sessionFactory;
    private final BikeTypeRepository bikeTypeRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final RotorFixTypeRepository rotorFixTypeRepository;
    private final HubRepository hubRepository;
    private final RimRepository rimRepository;
    private final TireRepository tireRepository;
    private final SpokeRepository spokeRepository;

    @Autowired
    public WheelServiceImpl(WheelRepository wheelRepository, WheelsDiamRepository wheelsDiamRepository,
                            SessionFactory sessionFactory, BikeTypeRepository bikeTypeRepository,
                            ManufacturerRepository manufacturerRepository, RotorFixTypeRepository rotorFixTypeRepository,
                            HubRepository hubRepository, RimRepository rimRepository,TireRepository tireRepository,
                            SpokeRepository spokeRepository) {
        this.wheelRepository = wheelRepository;
        this.wheelsDiamRepository = wheelsDiamRepository;
        this.sessionFactory = sessionFactory;
        this.bikeTypeRepository = bikeTypeRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.rotorFixTypeRepository = rotorFixTypeRepository;
        this.hubRepository = hubRepository;
        this.rimRepository = rimRepository;
        this.tireRepository = tireRepository;
        this.spokeRepository = spokeRepository;
    }

    @Override
    public SearchResultBO searchByCriteria(WheelSearchInputJSON input) {
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Wheel.class);
        if (input.getBikeTypeId() != null)
            searchCriteria.add(Restrictions.eq("bikeType",bikeTypeRepository.getOne(input.getBikeTypeId())));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if (input.getWheelsDiam() != null)
            searchCriteria.add(Restrictions.eq("wheelsDiam", input.getWheelsDiam()));
        if (input.getLocation() != null)
            searchCriteria.add(Restrictions.eq("location", input.getLocation()));
        if (input.getSpokeNumber() != null)
            searchCriteria.add(Restrictions.eq("spokeNumber", input.getSpokeNumber()));
        if (input.getBrakeType() != null)
            searchCriteria.add(Restrictions.eq("brakeType", input.getBrakeType()));
        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }

    @Override
    @Transactional(readOnly = true)
    public Wheel getWheel(Long id) {
        return wheelRepository.findOne(id);
    }

    @Override
    public SearchResultBO searchByCriteria(HubSearchInputJSON input) {
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Hub.class);
        if (input.getLocation() != null)
            searchCriteria.add(Restrictions.eq("location",input.getLocation()));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if (input.getHubBindingType() != null)
            searchCriteria.add(Restrictions.eq("hubBindingType", input.getHubBindingType()));
        if (input.getSpokeNumber() != null)
            searchCriteria.add(Restrictions.eq("spokeNumber", input.getSpokeNumber()));
        if (input.getBrakeType() != null)
            searchCriteria.add(Restrictions.eq("brakeType", input.getBrakeType()));
        if (input.getAxisDiam() != null)
            searchCriteria.add(Restrictions.eq("axisDiam", input.getAxisDiam()));
        if (input.getAxisLength() != null)
            searchCriteria.add(Restrictions.eq("axisLength", input.getAxisLength()));
        if (input.getRotorFixTypeId() != null)
            searchCriteria.add(Restrictions.eq("rotorFixType", rotorFixTypeRepository.getOne(input.getRotorFixTypeId())));
        if (input.getCogsetType() != null)
            searchCriteria.add(Restrictions.eq("cogsetType", input.getCogsetType()));
        if (input.getBackSprocketNumber() != null)
            searchCriteria.add(Restrictions.eq("backSprocketNumber", input.getBackSprocketNumber()));
        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }

    @Override
    public SearchResultBO searchByCriteria(RimSearchInputJSON input) {
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Rim.class);
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if (input.getSpokeNumber() != null)
            searchCriteria.add(Restrictions.eq("spokeNumber", input.getSpokeNumber()));
        if (input.getBrakeType() != null)
            searchCriteria.add(Restrictions.eq("brakeType", input.getBrakeType()));
        if (input.getBikeTypeId() != null)
            searchCriteria.add(Restrictions.eq("bikeType", bikeTypeRepository.getOne(input.getBikeTypeId())));
        if (input.getWheelsDiamId() != null)
            searchCriteria.add(Restrictions.eq("wheelsDiam", wheelsDiamRepository.getOne(input.getWheelsDiamId())));
        if (input.getRimHeight() != null)
            searchCriteria.add(Restrictions.eq("rimHeight", input.getRimHeight()));
        if (input.getRimWide() != null)
            searchCriteria.add(Restrictions.eq("rimWide", input.getRimWide()));

        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }

    @Override
    public SearchResultBO searchByCriteria(TireSearchInputJSON input) {
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Tire.class);
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if (input.getWheelsDiamId() != null)
            searchCriteria.add(Restrictions.eq("wheelsDiam", wheelsDiamRepository.getOne(input.getWheelsDiamId())));
        if (input.getTireType() != null)
            searchCriteria.add(Restrictions.eq("tireType", input.getTireType()));
        if (input.getTireWide() != null)
            searchCriteria.add(Restrictions.eq("tireWide", input.getTireWide()));

        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }

    @Override
    public SearchResultBO searchByCriteria(SpokeSearchInputJSON input) {
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Spoke.class);
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));

        if(input.getDiameter() != null)
            searchCriteria.add(Restrictions.eq("diameter", input.getDiameter()));
        if(input.getLength() != null)
            searchCriteria.add(Restrictions.eq("length", input.getLength()));

        ret.setTotalCount(getCount(searchCriteria));
        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
        searchCriteria.setMaxResults(input.getItemsPerPage());
        ret.setSearchResult(searchCriteria.list());
        session.close();
        return ret;
    }

    @Override
    public Rim getRim(Long id){
        return rimRepository.getOne(id);
    }

    @Override
    public Tire getTire(Long id){
        return tireRepository.getOne(id);
    }


    @Override
    public Hub getHub(Long id) {
        return hubRepository.getOne(id);
    }

    @Override
    public Spoke getSpoke(Long id) {
        return spokeRepository.getOne(id);
    }

    private Long getCount(Criteria searchCriteria) {
        searchCriteria.setProjection(Projections.rowCount());
        Long count =(Long) searchCriteria.uniqueResult();
        searchCriteria.setProjection(null);
        return count;
    }

}
