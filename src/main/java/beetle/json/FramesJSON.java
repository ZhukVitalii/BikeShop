package beetle.json;


public class FramesJSON {
    private Long frameId;
    private String bikeType;
    private String wheelsDiameter;
    private String material;
    private String headsetType;
    private String tubeDiameter;
    private String underSaddleTubeDiameter;
    private String brakesType;
    private String trunkBinding;
    private String weight;
    private String color;
    private Double price;
    private String description;
    private Long manufacturerId;
    private String manufacturerName;

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
