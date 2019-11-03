package beetle.json;

public class BrakeDiscHydraulicInputJSON extends BaseInputJSON {

    private Long locationId;
    private Long brakeLiquidId;
    private String materialHandle;
    private Long lengthHydrolineId;
    private Long rotorDiamId;
    private String rotorWeight;
    private String brakeWeight;
    private Long rotorFixTypeId;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getBrakeLiquidId() {
        return brakeLiquidId;
    }

    public void setBrakeLiquidId(Long brakeLiquidId) {
        this.brakeLiquidId = brakeLiquidId;
    }

    public String getMaterialHandle() {
        return materialHandle;
    }

    public void setMaterialHandle(String materialHandle) {
        this.materialHandle = materialHandle;
    }

    public Long getLengthHydrolineId() {
        return lengthHydrolineId;
    }

    public void setLengthHydrolineId(Long lengthHydrolineId) {
        this.lengthHydrolineId = lengthHydrolineId;
    }

    public Long getRotorDiamId() {
        return rotorDiamId;
    }

    public void setRotorDiamId(Long rotorDiamId) {
        this.rotorDiamId = rotorDiamId;
    }

    public String getRotorWeight() {
        return rotorWeight;
    }

    public void setRotorWeight(String rotorWeight) {
        this.rotorWeight = rotorWeight;
    }

    public String getBrakeWeight() {
        return brakeWeight;
    }

    public void setBrakeWeight(String brakeWeight) {
        this.brakeWeight = brakeWeight;
    }

    public Long getRotorFixTypeId() {
        return rotorFixTypeId;
    }

    public void setRotorFixTypeId(Long rotorFixTypeId) {
        this.rotorFixTypeId = rotorFixTypeId;
    }
}
