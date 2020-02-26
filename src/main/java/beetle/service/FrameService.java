package beetle.service;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.transmission.BracketWide;
import beetle.entity.frame.*;
import beetle.json.frame.FramesSearchInputJSON;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FrameService {
    void addToArticle(Long article);

    Long getArticleFromCart (int a);

    int getSize();

    void addFrame(Frame frame);

    void addFrameMaker(Manufacturer frameMaker);

    void addFrameSize(FrameSizeType frameSize);

    void addTrunkBinding(TrunkBinding trunkBinding);

    void addUnderSaddleTube(UnderSaddleTube underSaddleTube);

    void deleteFrame(long[] idList);

    List<Frame> findAll(Pageable pageable);

    List<Manufacturer> findFrameMakers();

    List<FrameSizeType> findFrameSize();

    List<WheelsDiam> findWheelsDiam();

    List<TrunkBinding> findTrunkBinding();

    List<BikeType> findBikeType();

    BikeType findBikeType(long id);

    List<BracketWide> findBracketWide();

    List<HeadsetType> findHeadsetType();

    List<TubeDiameter> findTubeDiameter();

    List<UnderSaddleTube> findUnderSaddleTube();

    List<BrakesType> findBrakesType();

    FrameSizeType findFrameSize(long id);

    Frame findFrame(Long id);

    Manufacturer findFrameMaker(long id);

    long count();

    SearchResultBO searchByCriteria(FramesSearchInputJSON input);
}
