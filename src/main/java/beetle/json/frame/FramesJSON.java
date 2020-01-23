package beetle.json.frame;


import beetle.json.BaseJSON;

public class FramesJSON extends BaseJSON {
    private Long frameId;
    private String bikeType;
    private String wheelsDiameter;
    private String material;
    private String headsetType;
    private String tubeDiameter;
    private String underSaddleTubeDiameter;
    private String brakesType;
    private String trunkBinding;


    public Long getFrameId() {
        return frameId;
    }

    public void setFrameId(Long frameId) {
        this.frameId = frameId;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getWheelsDiameter() {
        return wheelsDiameter;
    }

    public void setWheelsDiameter(String wheelsDiameter) {
        this.wheelsDiameter = wheelsDiameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getHeadsetType() {
        return headsetType;
    }

    public void setHeadsetType(String headsetType) {
        this.headsetType = headsetType;
    }

    public String getTubeDiameter() {
        return tubeDiameter;
    }

    public void setTubeDiameter(String tubeDiameter) {
        this.tubeDiameter = tubeDiameter;
    }

    public String getUnderSaddleTubeDiameter() {
        return underSaddleTubeDiameter;
    }

    public void setUnderSaddleTubeDiameter(String underSaddleTubeDiameter) {
        this.underSaddleTubeDiameter = underSaddleTubeDiameter;
    }

    public String getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(String brakesType) {
        this.brakesType = brakesType;
    }

    public String getTrunkBinding() {
        return trunkBinding;
    }

    public void setTrunkBinding(String trunkBinding) {
        this.trunkBinding = trunkBinding;
    }

}
