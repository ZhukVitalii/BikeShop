package beetle.mapper;


import beetle.entity.frame.Frame;
import beetle.entity.frame.FrameSizeType;
import beetle.json.frame.FrameSizeJSON;
import beetle.json.frame.FramesJSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JSONMapper {


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
            FramesJSON frame = new FramesJSON();
            frame.setFrameId(frameEntity.getId());
            frame.setBikeType(frameEntity.getBikeType().getType());
            frame.setBrakesType(frameEntity.getBrakesType().getType());
            frame.setColor(frameEntity.getColor());
            frame.setDescription(frameEntity.getDescription());
            frame.setHeadsetType(frameEntity.getHeadsetType().getType());
            frame.setMaterial(frameEntity.getMaterial());
            frame.setPrice(frameEntity.getPrice());
            frame.setTrunkBinding(frameEntity.getTrunkBinding().getTrunk());
            frame.setTubeDiameter(frameEntity.getTubeDiameter().getDiam());
            frame.setUnderSaddleTubeDiameter(frameEntity.getUnderSaddleTube().getDiam());
            frame.setWeight(frameEntity.getWeight());
            frame.setWheelsDiameter(frameEntity.getWheelsDiam().getDiam());
            ret.add(frame);
        }
        return ret;
    }
}
