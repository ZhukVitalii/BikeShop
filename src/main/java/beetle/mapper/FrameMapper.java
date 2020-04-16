package beetle.mapper;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.*;
import beetle.entity.handlebars.HeadsetType;
import beetle.json.SearchResultResponseJSON;
import beetle.json.frame.*;
import beetle.service.impl.FrameServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class FrameMapper extends BaseMapper{

    @Autowired
    private FrameServiceImpl frameServiceImpl;

    public Frame toFrame(FrameInputJSON input) {
        Frame ret = new Frame();


        Manufacturer frameMaker = frameServiceImpl.findFrameMaker(input.getManufacturerId());
        BikeType bikeType = frameServiceImpl.findBikeType(input.getBikeTypeId());
//        FrameSizeType frameSize = frameServiceImpl.findFrameSize(input.getFrameSizeId());
        WheelsDiam wheelsDiam = frameServiceImpl.findWheelsDiam(input.getWheelsDiamId());
        HeadsetType headsetType = frameServiceImpl.findHeadsetType(input.getHeadsetTypeId());
        TubeDiameter tubeDiameter = frameServiceImpl.findTubeDiameter(input.getTubeDiameterId()) ;
        UnderSaddleTube underSaddleTube = frameServiceImpl.findUnderSaddleTuber(input.getUnderSaddleTubeId()) ;
        BrakesType brakesType =  frameServiceImpl.findBrakesType(input.getBrakesTypeId()) ;
        TrunkBinding trunkBinding = frameServiceImpl.findTrunkBinding(input.getTrunkBindingId()) ;

        ret.setBikeType(bikeType);
        ret.setBracketWide(input.getBracketWide());
        ret.setBrakesType(brakesType);
//        ret.setFrameSizeType(frameSize);
        ret.setHeadsetType(headsetType);
        ret.setTrunkBinding(trunkBinding);
        ret.setTubeDiameter(tubeDiameter);
        ret.setUnderSaddleTube(underSaddleTube);
        ret.setWheelsDiam(wheelsDiam);
        ret.setArticle(input.getArticle());
        ret.setColor(input.getColor());
        ret.setDescription(input.getDescription());
        ret.setManufacturer(frameMaker);
        ret.setName(input.getName());
        ret.setPrice(input.getPrice());
        ret.setUrl(input.getUrl());
        ret.setWay(input.getWay());
        ret.setWeight(input.getWeight());
        ret.setMaterial(input.getMaterial());
        return ret;
    }

    public List<FrameSizeJSON> toFrameSize(List<FrameSizeType> frameSizes) {
        List<FrameSizeJSON> ret = new ArrayList<>();

        for (FrameSizeType frameSize : frameSizes) {
            FrameSizeJSON sizeJSON = new FrameSizeJSON();
            sizeJSON.setId(frameSize.getId());
            sizeJSON.setSize(frameSize.getSize());
            ret.add(sizeJSON);
        }

        return ret;
    }

    public List<FramesJSON> toFrames(List<Frame> dest){
        List<FramesJSON> ret = new ArrayList<>();
        for (Frame frameEntity : dest) {
            ret.add(toFrame(frameEntity));
        }
        return ret;
    }

    public SearchResultResponseJSON toSearchResult(List<Frame> frames, FramesSearchInputJSON input) {
        if (frames == null)
            return null;
        SearchResultResponseJSON ret = new SearchResultResponseJSON();
        ret.setResultResponse(toFrames(frames));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }

    public FramesJSON toFrame(Frame frame) {
        FramesJSON ret = new FramesJSON();
        ret.setFrameId(frame.getId());
        ret.setBikeType(frame.getBikeType().getType());
        ret.setBrakesType(frame.getBrakesType().getType());
        ret.setHeadsetType(frame.getHeadsetType().getType());
        ret.setMaterial(frame.getMaterial());
        ret.setTrunkBinding(frame.getTrunkBinding().getTrunk());
        ret.setTubeDiameter(frame.getTubeDiameter().getDiam());
        ret.setUnderSaddleTubeDiameter(frame.getUnderSaddleTube().getDiam());
        ret.setWheelsDiameter(frame.getWheelsDiam().getDiam());
        ret.setWheelsDiameterId(frame.getWheelsDiam().getId());
        ret.setBracketWide(frame.getBracketWide());
        ret.setFrameSizeTypes(toFrameSizes(frame.getFrameSizeTypes()));
        setBaseParameter(ret, frame);
        return ret;
    }

    private Set<FrameSizeJSON> toFrameSizes(Set<FrameSizeType> frameSizeTypes){
        Set<FrameSizeJSON> ret = new HashSet<>();
        frameSizeTypes.stream().forEach( e -> {
            FrameSizeJSON frameSize = new FrameSizeJSON();
            frameSize.setId(e.getId());
            frameSize.setSize(e.getSize());
            ret.add(frameSize);
        });

        return ret;
    }

}
