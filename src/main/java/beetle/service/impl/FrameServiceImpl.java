package beetle.service.impl;

import beetle.bo.SearchResultBO;
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
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

//    @Override
//    @Transactional
//    public SearchResultBO searchByCriteria(FramesSearchInputJSON input){
//        SearchResultBO ret = new SearchResultBO();
//        Session session = sessionFactory.openSession();
//        Criteria searchCriteria = session.createCriteria(Frame.class);
//        if (input.getBikeTypeId() != null)
//            searchCriteria.add(Restrictions.eq("bikeType",bikeTypeRepository.getOne(input.getBikeTypeId())));
//        if(input.getManufacturerId() != null)
//            searchCriteria.add(Restrictions.eq("manufacturer", manufacturerRepository.findOne(input.getManufacturerId())));
////        if(input.getFrameSizeId() != null)
////            searchCriteria.add(Restrictions.in("frameSizeTypes", frameSizeRepository.findOne(input.getFrameSizeId())));
//        if(input.getFrameSizeId() != null) {
//            searchCriteria.setResultTransformer(Criteria.ROOT_ENTITY);
//            searchCriteria.createAlias("frameSizeTypes", "frameSizeTypesAlias");
//            searchCriteria.add(Restrictions.in("frameSizeTypesAlias.size", Arrays.asList("1","2","3","4")));
//        }
//        if (input.getWheelsDiamId() != null)
//            searchCriteria.add(Restrictions.eq("wheelsDiam", wheelsDiamRepository.findOne(input.getWheelsDiamId())));
//        if (input.getBracketWideId() != null)
//            searchCriteria.add(Restrictions.eq("bracketWide", bracketWideRepository.findOne(input.getBracketWideId())));
//        if (input.getTubeDiameterId() != null)
//            searchCriteria.add(Restrictions.eq("tubeDiameter", tubeDiameterRepository.findOne(input.getTubeDiameterId())));
//        if (input.getUnderSaddleTubeId() != null)
//            searchCriteria.add(Restrictions.eq("underSaddleTube", underSaddleTubeRepository.findOne(input.getUnderSaddleTubeId())));
//        if (input.getBrakesTypeId() != null)
//            searchCriteria.add(Restrictions.eq("brakeType", brakesTypeRepository.findOne(input.getBrakesTypeId())));
//        ret.setTotalCount(getCount(searchCriteria));
//        searchCriteria.setFirstResult(input.getItemsPerPage() * input.getPage());
//        searchCriteria.setMaxResults(input.getItemsPerPage());
//        ret.setSearchResult(searchCriteria.list());
//        session.close();
//        return ret;
//    }
    @Transactional
    public SearchResultBO searchByCriteria(FramesSearchInputJSON input) {
        ParameterExpression<String> frameSizeParam = null;
        SearchResultBO ret = new SearchResultBO();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Frame> searchQuery = cb.createQuery(Frame.class);
        Root<Frame> root = searchQuery.from(Frame.class);
        List<Predicate> predicates = buildPredicates(root,cb,input);

        if(input.getFrameSize() != null) {
            Join<Frame, FrameSizeType> frameSizeType = root.join("frameSizeTypes");
            frameSizeParam = cb.parameter(String.class);
            predicates.add(cb.equal(frameSizeType.get("size"), frameSizeParam));
        }
        Predicate[] predicatesArray = predicates.stream().toArray(Predicate[]::new);
        searchQuery.select(root).where(predicatesArray);
        TypedQuery<Frame> query = session.createQuery(searchQuery);

        if(input.getFrameSize() != null) {
            query.setParameter(frameSizeParam, input.getFrameSize());
        }
        Long count = new Long (query.getResultList().size());
        setPagging(query,input);
        List<Frame> frames = query.getResultList();
        ret.setTotalCount(count);
        ret.setSearchResult(frames.stream().map( e -> (Object) e).collect(Collectors.toList()));
        session.close();
        return ret;
    }

//    private Long getCount(Predicate[] predicatesArray, Session session,CriteriaBuilder cb){
//        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
//        countQuery.select(cb.count(countQuery.from(Frame.class)));
//        session.createQuery(countQuery);
//        countQuery.where(predicatesArray);
//
//        return session.createQuery(countQuery).getSingleResult();
//    }


// todo migrate to this method
    private Long getCount(FramesSearchInputJSON input){
        Session session = sessionFactory.openSession();
        ParameterExpression<Long> frameSizeParam = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Frame> root = countQuery.from(Frame.class);

        List<Predicate> predicates = buildPredicates(root,cb,input);

        if(input.getFrameSizeId() != null) {
            Join<Object, Object> frameSizeType = root.join("frameSizeTypes",JoinType.INNER);
            frameSizeParam = cb.parameter(Long.class);
            predicates.add(cb.equal(frameSizeType.get("id"), frameSizeParam));
        }

        countQuery.select(cb.count(countQuery.from(Frame.class))).where(predicates.stream().toArray(Predicate[]::new));
        Query<Long> query = session.createQuery(countQuery);
        if(input.getFrameSizeId() != null) {
            query.setParameter(frameSizeParam, input.getFrameSizeId());
        }

        Long count = query.getSingleResult();
        session.close();
        return count;
    }


    private void setPagging(TypedQuery<Frame> query,FramesSearchInputJSON input){
        query.setFirstResult(input.getItemsPerPage() * input.getPage());
        query.setMaxResults(input.getItemsPerPage());
    }
    private List<Predicate> buildPredicates(Root<Frame> root,CriteriaBuilder cb,FramesSearchInputJSON input){
        List<Predicate> predicates = new ArrayList<>();
        if (input.getBikeTypeId() != null)
            predicates.add(cb.equal(root.get("bikeType"),bikeTypeRepository.getOne(input.getBikeTypeId())));
        if(input.getManufacturerId() != null)
            predicates.add(cb.equal(root.get("manufacturer"),manufacturerRepository.findOne(input.getManufacturerId())));
        if (input.getWheelsDiamId() != null)
            predicates.add(cb.equal(root.get("wheelsDiam"),wheelsDiamRepository.findOne(input.getWheelsDiamId())));
        if (input.getBracketWideId() != null)
            predicates.add(cb.equal(root.get("bracketWide"),bracketWideRepository.findOne(input.getBracketWideId())));
        if (input.getTubeDiameterId() != null)
            predicates.add(cb.equal(root.get("tubeDiameter"),tubeDiameterRepository.findOne(input.getTubeDiameterId())));
        if (input.getUnderSaddleTubeId() != null)
            predicates.add(cb.equal(root.get("underSaddleTube"),underSaddleTubeRepository.findOne(input.getUnderSaddleTubeId())));
        if (input.getBrakesTypeId() != null)
            predicates.add(cb.equal(root.get("brakeType"),brakesTypeRepository.findOne(input.getBrakesTypeId())));


        return predicates;
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
