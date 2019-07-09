package beetle;


import beetle.Frames.Frame;
import beetle.Frames.FrameSize;
import beetle.JSON.FrameSizeJSON;
import beetle.JSON.FramesJSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JSONMapper {


    public List<FrameSizeJSON> toFrameSize(List<FrameSize> frameSizes) {
        List<FrameSizeJSON> ret = new ArrayList<>();

        for (FrameSize frameSize : frameSizes) {
            FrameSizeJSON sizeJSON = new FrameSizeJSON();
            sizeJSON.setId(frameSize.getId());
            sizeJSON.setSize(frameSize.getSize());
            ret.add(sizeJSON);
        }

        return ret;
    }

    public List<FramesJSON> toFrames(List<Frame> dest){
        List<FramesJSON> ret = new ArrayList<>();

        return ret;
    }
}
