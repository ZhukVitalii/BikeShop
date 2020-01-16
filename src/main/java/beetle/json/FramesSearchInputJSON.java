package beetle.json;

import beetle.enums.BikeTypeEnum;

public class FramesSearchInputJSON extends PaggingJSON {
    private Long bikeTypeId;
    private BikeTypeEnum bikeType;
    private Long frameSizeId;
    private Long manufacturerId;

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getBikeTypeId() {
        return bikeTypeId;
    }

    public void setBikeTypeId(Long bikeTypeId) {
        this.bikeTypeId = bikeTypeId;
    }

    public BikeTypeEnum getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeTypeEnum bikeType) {
        this.bikeType = bikeType;
    }

    public Long getFrameSizeId() {
        return frameSizeId;
    }

    public void setFrameSizeId(Long frameSizeId) {
        this.frameSizeId = frameSizeId;
    }
}
