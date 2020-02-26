package beetle.service.impl;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.handlebars.HeadsetType;
import beetle.json.frame.FramesSearchInputJSON;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.BrakesTypeRepository;
import beetle.repository.forks.TubeDiameterRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.handlebars.HeadsetTypeRepository;
import beetle.entity.transmission.BracketWide;
import beetle.repository.transmission.BracketWideRepository;
import beetle.entity.frame.*;
import beetle.repository.frame.*;
import beetle.service.FrameService;
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
public class FrameServiceImpl implements FrameService {
    private final FrameRepository frameRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final FrameSizeRepository frameSizeRepository;
    private final UnderSaddleTubeRepository underSaddleTubeRepository;
    private final TrunkBindingRepository trunkBindingRepository;
    private final BikeTypeRepository bikeTypeRepository;
    private final BrakesTypeRepository brakesTypeRepository;
    private final HeadsetTypeRepository headsetTypeRepository;
    private final TubeDiameterRepository tubeDiameterRepository;
    private final BracketWideRepository bracketWideRepository;
    private final WheelsDiamRepository wheelsDiamRepository ;
    private final SessionFactory sessionFactory;

    @Autowired
    public FrameServiceImpl(FrameRepository frameRepository, ManufacturerRepository manufacturerRepository, FrameSizeRepository frameSizeRepository,
                            UnderSaddleTubeRepository underSaddleTubeRepository, TrunkBindingRepository trunkBindingRepository,
                            BikeTypeRepository bikeTypeRepository, BrakesTypeRepository brakesTypeRepository, HeadsetTypeRepository headsetTypeRepository,
                            TubeDiameterRepository tubeDiameterRepository, BracketWideRepository bracketWideRepository, WheelsDiamRepository wheelsDiamRepository, SessionFactory sessionFactory) {
        this.frameRepository = frameRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.frameSizeRepository = frameSizeRepository;
        this.underSaddleTubeRepository = underSaddleTubeRepository;
        this.trunkBindingRepository = trunkBindingRepository;
        this.bikeTypeRepository = bikeTypeRepository;
        this.brakesTypeRepository = brakesTypeRepository;
        this.headsetTypeRepository = headsetTypeRepository;
        this.tubeDiameterRepository = tubeDiameterRepository;
        this.bracketWideRepository = bracketWideRepository;
        this.wheelsDiamRepository = wheelsDiamRepository;
        this.sessionFactory = sessionFactory;
    }


    //Lists with articles of components, that user added to cart
    private List<Long> articles = new ArrayList<>();

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
    //get size of List
    public int getSize() {
        int a = articles.size();
        return a;
    }

    // add
    @Transactional
    public void addFrame(Frame frame) {
        frameRepository.save(frame);
    }

    @Transactional
    public void addFrameMaker(Manufacturer frameMaker) {
        manufacturerRepository.save(frameMaker);
    }

    @Transactional
    public void addFrameSize(FrameSizeType frameSize) {
        frameSizeRepository.save(frameSize);
    }

    @Transactional
    public void addTrunkBinding(TrunkBinding trunkBinding) {
        trunkBindingRepository.save(trunkBinding);
    }

    @Transactional
    public void addUnderSaddleTube(UnderSaddleTube underSaddleTube) {
        underSaddleTubeRepository.save(underSaddleTube);
    }

    //delete frame from database for admin
    @Transactional
    public void deleteFrame(long[] idList) {
        for (long id : idList)
            frameRepository.delete(id);
    }

    //find all components from database
    @Transactional(readOnly=true)
    public List<Frame> findAll(Pageable pageable) {
        return frameRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional
    public SearchResultBO searchByCriteria(FramesSearchInputJSON input){
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        Criteria searchCriteria = session.createCriteria(Frame.class);
        if (input.getBikeTypeId() != null)
            searchCriteria.add(Restrictions.eq("bikeType",bikeTypeRepository.getOne(input.getBikeTypeId())));
        if(input.getManufacturerId() != null)
            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
        if(input.getFrameSizeId() != null)
            searchCriteria.add(Restrictions.eq("frameSizeType", frameSizeRepository.findOne(input.getFrameSizeId())));
        if (input.getWheelsDiamId() != null)
            searchCriteria.add(Restrictions.eq("wheelsDiam", wheelsDiamRepository.findOne(input.getWheelsDiamId())));
        if (input.getBracketWideId() != null)
            searchCriteria.add(Restrictions.eq("bracketWide", bracketWideRepository.findOne(input.getBracketWideId())));
        if (input.getTubeDiameterId() != null)
            searchCriteria.add(Restrictions.eq("tubeDiameter", tubeDiameterRepository.findOne(input.getTubeDiameterId())));
        if (input.getUnderSaddleTubeId() != null)
            searchCriteria.add(Restrictions.eq("underSaddleTube", underSaddleTubeRepository.findOne(input.getUnderSaddleTubeId())));
        if (input.getBrakesTypeId() != null)
            searchCriteria.add(Restrictions.eq("brakeType", brakesTypeRepository.findOne(input.getBrakesTypeId())));
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

    @Transactional(readOnly=true)
    public List<Manufacturer> findFrameMakers() {
        return manufacturerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<FrameSizeType> findFrameSize() {
        return frameSizeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<WheelsDiam> findWheelsDiam() {
        return wheelsDiamRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<TrunkBinding> findTrunkBinding() {
        return trunkBindingRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BikeType> findBikeType() {
        return bikeTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BracketWide> findBracketWide() {
        return bracketWideRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<HeadsetType> findHeadsetType() {
        return headsetTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<TubeDiameter> findTubeDiameter() {
        return tubeDiameterRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<UnderSaddleTube> findUnderSaddleTube() {
        return underSaddleTubeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BrakesType> findBrakesType() {
        return brakesTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Frame> findByPattern(String pattern, Pageable pageable) {
        return frameRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly = true)
    public long count() {
        return frameRepository.count();
    }

    //find by id
    @Override
    @Transactional(readOnly = true)
    public  Frame findFrame(Long id) {
        return frameRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public Manufacturer findFrameMaker(long id) {
        return manufacturerRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly=true)
    public FrameSizeType findFrameSize(long id) {
        return frameSizeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public WheelsDiam findWheelsDiam(long id) {
        return wheelsDiamRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public TrunkBinding findTrunkBinding(long id) {
        return trunkBindingRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BracketWide findBracketWide(long id) {
        return bracketWideRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public TubeDiameter findTubeDiameter(long id) {
        return tubeDiameterRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public UnderSaddleTube findUnderSaddleTuber(long id) {
        return underSaddleTubeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public HeadsetType findHeadsetType(long id) {
        return headsetTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BrakesType findBrakesType(long id) {
        return brakesTypeRepository.findOne(id);
    }

}
