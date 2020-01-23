package beetle.json.brakes;

import beetle.enums.brakes.BrakeSubTypeEnum;
import beetle.enums.brakes.BrakeType;
import beetle.enums.brakes.LocationType;
import beetle.json.PaggingJSON;

public class BrakeSearchInputJSON extends PaggingJSON {
    private BrakeType brakeType;
    private BrakeSubTypeEnum brakeSubType;
    private LocationType location;
    private Double rotorDiam;
    private String rotorFixType;
    private Long manufacturerId;

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

    public Double getRotorDiam() {
        return rotorDiam;
    }

    public void setRotorDiam(Double rotorDiam) {
        this.rotorDiam = rotorDiam;
    }

    public String getRotorFixType() {
        return rotorFixType;
    }

    public void setRotorFixType(String rotorFixType) {
        this.rotorFixType = rotorFixType;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
