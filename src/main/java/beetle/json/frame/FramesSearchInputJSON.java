package beetle.json.frame;

import beetle.enums.BikeTypeEnum;
import beetle.json.PaggingJSON;

public class FramesSearchInputJSON extends PaggingJSON {
    private Long bikeTypeId;
    private BikeTypeEnum bikeType;
    private Long frameSizeId;
    private Long manufacturerId;
    private Long wheelsDiamId;
    private Long bracketWideId;
    private Long headsetTypeId;
    private Long tubeDiameterId;
    private Long underSaddleTubeId;
    private Long brakesTypeId;

    public Long getBrakesTypeId() {
        return brakesTypeId;
    }

    public void setBrakesTypeId(Long brakesTypeId) {
        this.brakesTypeId = brakesTypeId;
    }

    public Long getWheelsDiamId() {
        return wheelsDiamId;
    }

    public void setWheelsDiamId(Long wheelsDiamId) {
        this.wheelsDiamId = wheelsDiamId;
    }

    public Long getBracketWideId() {
        return bracketWideId;
    }

    public void setBracketWideId(Long bracketWideId) {
        this.bracketWideId = bracketWideId;
    }

    public Long getHeadsetTypeId() {
        return headsetTypeId;
    }

    public void setHeadsetTypeId(Long headsetTypeId) {
        this.headsetTypeId = headsetTypeId;
    }

    public Long getTubeDiameterId() {
        return tubeDiameterId;
    }

    public void setTubeDiameterId(Long tubeDiameterId) {
        this.tubeDiameterId = tubeDiameterId;
    }

    public Long getUnderSaddleTubeId() {
        return underSaddleTubeId;
    }

    public void setUnderSaddleTubeId(Long underSaddleTubeId) {
        this.underSaddleTubeId = underSaddleTubeId;
    }

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
