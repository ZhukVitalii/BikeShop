package beetle.service.impl;

import beetle.Forks.*;
import beetle.FrameSearchParams;
import beetle.Frames.*;
import beetle.Handlebars.HeadsetType;
import beetle.Handlebars.HeadsetTypeRepository;
import beetle.Transmissions.BracketWide;
import beetle.Transmissions.BracketWideRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrameServiceImpl {
    @Autowired
    private FrameRepository frameRepository;


    @Autowired
    private FrameMakerRepository frameMakerRepository;
    @Autowired
    private FrameSizeRepository frameSizeRepository;
    @Autowired
    private UnderSaddleTubeRepository underSaddleTubeRepository;
    @Autowired
    private TrunkBindingRepository trunkBindingRepository;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;
    @Autowired
    private BrakesTypeRepository brakesTypeRepository;
    @Autowired
    private HeadsetTypeRepository headsetTypeRepository;
    @Autowired
    private TubeDiameterRepository tubeDiameterRepository;
    @Autowired
    private BracketWideRepository bracketWideRepository;
    @Autowired
    private WheelsDiamRepository wheelsDiamRepository ;
//    @Autowired
//    SessionFactory sessionFactory;


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
    public void addFrameMaker(FrameMaker frameMaker) {
        frameMakerRepository.save(frameMaker);
    }

    @Transactional
    public void addFrameSize(FrameSize frameSize) {
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

    @Transactional(readOnly=true)
    public List<FrameMaker> findFrameMakers() {
        return frameMakerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<FrameSize> findFrameSize() {
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

    //select from database by parametrs
    @Transactional(readOnly=true)
    public List<Frame> findByFrameMaker(FrameMaker frameMaker, Pageable pageable) {
        return frameRepository.findByFrameMaker(frameMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByFrameSize(FrameSize frameSize, Pageable pageable) {
        return frameRepository.findByFrameSize(frameSize, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByWheelsDiam(WheelsDiam wheelsDiam, Pageable pageable) {
        return frameRepository.findByWheelsDiam(wheelsDiam, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByUrl(String url, Pageable pageable) {
        return frameRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByArticle(Long article, Pageable pageable) {
        return frameRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByTypeAndSize(BikeType bikeType,FrameSize frameSize, Pageable pageable) {
        return frameRepository.findByTypeAndSize(bikeType, frameSize, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findBySizeM( FrameSize frameSize , Pageable pageable) {
        return frameRepository.findBySize( frameSize, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findBySizeL( FrameSize frameSize , Pageable pageable) {
        return frameRepository.findBySize( frameSize, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findBySizeS( FrameSize frameSize , Pageable pageable) {
        return frameRepository.findBySize( frameSize, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByBikeType(BikeType bikeType, Pageable pageable) {
        return frameRepository.findByBikeType(bikeType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByTrunkBinding(TrunkBinding trunkBinding, Pageable pageable) {
        return frameRepository.findByTrunkBinding(trunkBinding, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByBracketWide(BracketWide bracketWide, Pageable pageable) {
        return frameRepository.findByBracketWide(bracketWide, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByHeadsetType(HeadsetType headsetType, Pageable pageable) {
        return frameRepository.findByHeadsetType(headsetType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByTubeDiameter(TubeDiameter tubeDiameter, Pageable pageable) {
        return frameRepository.findByTubeDiameter(tubeDiameter, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByUnderSaddleTube(UnderSaddleTube underSaddleTube, Pageable pageable) {
        return frameRepository.findByUnderSaddleTube(underSaddleTube, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByBrakesType(BrakesType brakesType, Pageable pageable) {
        return frameRepository.findByBrakesType( brakesType, pageable);
    }

    @Transactional(readOnly=true)
    public List<Frame> findByPattern(String pattern, Pageable pageable) {
        return frameRepository.findByPattern(pattern, pageable);
    }

    //Count
    @Transactional(readOnly = true)
    public long countByFrameMaker(FrameMaker frameMaker) {
        return frameRepository.countByFrameMaker(frameMaker);
    }

    @Transactional(readOnly = true)
    public long count() {
        return frameRepository.count();
    }

    //find by id

    @Transactional(readOnly = true)
    public  Frame findFrame(Long id) {
        return frameRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public FrameMaker findFrameMaker(long id) {
        return frameMakerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public FrameSize findFrameSize(long id) {
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


    @Transactional(readOnly = true)
    public List<Frame> frames(FrameSearchParams fsp,Pageable pageable) {

        return frameRepository.findFrame(
//             fsp.getFrameMaker(),
//             fsp.getUrl(),
//             fsp.getArticle(),
//             fsp.getBikeType(),
//             fsp.getFrameSize(),
//             fsp.getWheelsDiam(),
             fsp.getBracketWide(),
//             fsp.getHeadsetType(),
//             fsp.getTubeDiameter(),
//             fsp.getUnderSaddleTube(),
//             fsp.getBrakesType(),
//             fsp.getTrunkBinding(),
             pageable);

    }
}
