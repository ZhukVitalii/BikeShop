package beetle.service;

import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.transmission.BracketWide;
import beetle.entity.frame.*;
import beetle.json.FramesSearchInputJSON;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FrameService {
    void addToArticle(Long article);

    Long getArticleFromCart (int a);

    int getSize();

    void addFrame(Frame frame);

    void addFrameMaker(Manufacturer frameMaker);

    void addFrameSize(FrameSize frameSize);

    void addTrunkBinding(TrunkBinding trunkBinding);

    void addUnderSaddleTube(UnderSaddleTube underSaddleTube);

    void deleteFrame(long[] idList);

    List<Frame> findAll(Pageable pageable);

    List<Manufacturer> findFrameMakers();

    List<FrameSize> findFrameSize();

    List<WheelsDiam> findWheelsDiam();

    List<TrunkBinding> findTrunkBinding();

    List<BikeType> findBikeType();

    BikeType findBikeType(long id);

    List<BracketWide> findBracketWide();

    List<HeadsetType> findHeadsetType();

    List<TubeDiameter> findTubeDiameter();

    List<UnderSaddleTube> findUnderSaddleTube();

    List<BrakesType> findBrakesType();

    List<Frame> findByFrameMaker(Manufacturer frameMaker, Pageable pageable);

    List<Frame> findByFrameSize(FrameSize frameSize, Pageable pageable);

    List<Frame> findByWheelsDiam(WheelsDiam wheelsDiam, Pageable pageable);

    List<Frame> findByUrl(String url, Pageable pageable);

    List<Frame> findByArticle(Long article, Pageable pageable);

    List<Frame> findByTypeAndSize(BikeType bikeType,FrameSize frameSize, Pageable pageable);

    List<Frame> findBySize(FrameSize frameSize , Pageable pageable);

    List<Frame> findByBikeType(BikeType bikeType, Pageable pageable);

    FrameSize findFrameSize(long id);

    Frame findFrame(Long id);

    Manufacturer findFrameMaker(long id);

    long count();

    long countByFrameMaker(Manufacturer frameMaker);

    List<Frame> searchByCriteria(FramesSearchInputJSON input);
}
