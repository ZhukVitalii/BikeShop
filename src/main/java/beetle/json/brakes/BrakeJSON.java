package beetle.json.brakes;

import beetle.enums.brakes.BrakeSubTypeEnum;
import beetle.enums.brakes.BrakeType;
import beetle.enums.brakes.LocationType;
import beetle.json.BaseJSON;


public class BrakeJSON extends BaseJSON {
    private Long id;
    private BrakeType brakeType;
    private BrakeSubTypeEnum brakeSubType;
    private LocationType location;
    private String brakeLiquid;
    private String materialHandle;
    private Double lengthHydroline;
    private Double rotorDiam;
    private String rotorWeight;
    private String brakeWeight;
    private String rotorFixType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }

    public BrakeSubTypeEnum getBrakeSubType() {
        return brakeSubType;
    }

    public void setBrakeSubType(BrakeSubTypeEnum brakeSubType) {
        this.brakeSubType = brakeSubType;
    }

    public LocationType getLocation() {
        return location;
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    public String getBrakeLiquid() {
        return brakeLiquid;
    }

    public void setBrakeLiquid(String brakeLiquid) {
        this.brakeLiquid = brakeLiquid;
    }

    public String getMaterialHandle() {
        return materialHandle;
    }

    public void setMaterialHandle(String materialHandle) {
        this.materialHandle = materialHandle;
    }

    public Double getLengthHydroline() {
        return lengthHydroline;
    }

    public void setLengthHydroline(Double lengthHydroline) {
        this.lengthHydroline = lengthHydroline;
    }

    public Double getRotorDiam() {
        return rotorDiam;
    }

    public void setRotorDiam(Double rotorDiam) {
        this.rotorDiam = rotorDiam;
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

    public String getRotorFixType() {
        return rotorFixType;
    }

    public void setRotorFixType(String rotorFixType) {
        this.rotorFixType = rotorFixType;
    }
}
