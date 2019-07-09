package beetle.JSON;

import beetle.Frames.BikeTypeEnum;

public class FramesSearchInputJSON extends PaggingJSON {
    private long bikeTypeId;
    private BikeTypeEnum bikeType;
    private long frameSizeId;

    public long getFrameSizeId() {
        return frameSizeId;
    }

    public void setFrameSizeId(long frameSizeId) {
        this.frameSizeId = frameSizeId;
    }

    public long getBikeTypeId() {
        return bikeTypeId;
    }

    public void setBikeTypeId(long bikeTypeId) {
        this.bikeTypeId = bikeTypeId;
    }

    public BikeTypeEnum getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeTypeEnum bikeType) {
        this.bikeType = bikeType;
    }
}
