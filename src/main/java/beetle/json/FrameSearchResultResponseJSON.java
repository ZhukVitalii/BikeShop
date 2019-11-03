package beetle.json;

import java.util.List;

public class FrameSearchResultResponseJSON extends PaggingJSON {
    private List<FramesJSON> frames;

    public List<FramesJSON> getFrames() {
        return frames;
    }

    public void setFrames(List<FramesJSON> frames) {
        this.frames = frames;
    }
}
