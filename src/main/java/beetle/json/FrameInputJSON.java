package beetle.json;

import org.springframework.web.bind.annotation.RequestParam;

public class FrameInputJSON extends BaseInputJSON{
    Long bikeTypeId;
    Long frameSizeId;
    Long wheelsDiamId;
    String material;
    Long bracketWideId;
    Long headsetTypeId;
    Long tubeDiameterId;
    Long underSaddleTubeId;
    Long brakesTypeId;
    Long trunkBindingId;

    public Long getBikeTypeId() {
        return bikeTypeId;
    }

    public void setBikeTypeId(Long bikeTypeId) {
        this.bikeTypeId = bikeTypeId;
    }

    public Long getFrameSizeId() {
        return frameSizeId;
    }

    public void setFrameSizeId(Long frameSizeId) {
        this.frameSizeId = frameSizeId;
    }

    public Long getWheelsDiamId() {
        return wheelsDiamId;
    }

    public void setWheelsDiamId(Long wheelsDiamId) {
        this.wheelsDiamId = wheelsDiamId;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(String material) {
        this.material = material;
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

    public Long getBrakesTypeId() {
        return brakesTypeId;
    }

    public void setBrakesTypeId(Long brakesTypeId) {
        this.brakesTypeId = brakesTypeId;
    }

    public Long getTrunkBindingId() {
        return trunkBindingId;
    }

    public void setTrunkBindingId(Long trunkBindingId) {
        this.trunkBindingId = trunkBindingId;
    }
}
