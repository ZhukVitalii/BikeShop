package beetle.service;

import beetle.Forks.BrakesType;
import beetle.Forks.TubeDiameter;
import beetle.Forks.WheelsDiam;
import beetle.Frames.*;
import beetle.Handlebars.HeadsetType;
import beetle.Transmissions.BracketWide;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FrameService {
    void addToArticle(Long article);

    Long getArticleFromCart (int a);

    int getSize();

    void addFrame(Frame frame);

    void addFrameMaker(FrameMaker frameMaker);

    void addFrameSize(FrameSize frameSize);

    void addTrunkBinding(TrunkBinding trunkBinding);

    void addUnderSaddleTube(UnderSaddleTube underSaddleTube);

    void deleteFrame(long[] idList);

    List<Frame> findAll(Pageable pageable);

    List<FrameMaker> findFrameMakers();

    List<FrameSize> findFrameSize();

    List<WheelsDiam> findWheelsDiam();

    List<TrunkBinding> findTrunkBinding();

    List<BikeType> findBikeType();

    List<BracketWide> findBracketWide();

    List<HeadsetType> findHeadsetType();

    List<TubeDiameter> findTubeDiameter();

    List<UnderSaddleTube> findUnderSaddleTube();

    List<BrakesType> findBrakesType();

    List<Frame> findByFrameMaker(FrameMaker frameMaker, Pageable pageable);

    List<Frame> findByFrameSize(FrameSize frameSize, Pageable pageable);

    List<Frame> findByWheelsDiam(WheelsDiam wheelsDiam, Pageable pageable);

    List<Frame> findByUrl(String url, Pageable pageable);

    List<Frame> findByArticle(Long article, Pageable pageable);

    List<Frame> findByTypeAndSize(BikeType bikeType,FrameSize frameSize, Pageable pageable);

    List<Frame> findBySizeM( FrameSize frameSize , Pageable pageable);
}
