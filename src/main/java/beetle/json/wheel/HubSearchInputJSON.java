package beetle.json.wheel;

import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeType;
import beetle.enums.transmission.CogsetType;
import beetle.enums.transmission.HubBindingType;
import beetle.json.PaggingJSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class HubSearchInputJSON extends PaggingJSON {
    private LocationType location;
    private HubBindingType hubBindingType;
    private String bearingType;
    private Double axisLength;
    private Double axisDiam;
    private BrakeType brakeType;
    private Long rotorFixTypeId;
    private Long spokeNumber;
    private CogsetType cogsetType;
    private Long backSprocketNumber;
    private Long manufacturerId;

    public LocationType getLocation() {
        return location;
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    public HubBindingType getHubBindingType() {
        return hubBindingType;
    }

    public void setHubBindingType(HubBindingType hubBindingType) {
        this.hubBindingType = hubBindingType;
    }

    public String getBearingType() {
        return bearingType;
    }

    public void setBearingType(String bearingType) {
        this.bearingType = bearingType;
    }

    public Double getAxisLength() {
        return axisLength;
    }

    public void setAxisLength(Double axisLength) {
        this.axisLength = axisLength;
    }

    public Double getAxisDiam() {
        return axisDiam;
    }

    public void setAxisDiam(Double axisDiam) {
        this.axisDiam = axisDiam;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }

    public Long getRotorFixTypeId() {
        return rotorFixTypeId;
    }

    public void setRotorFixTypeId(Long rotorFixTypeId) {
        this.rotorFixTypeId = rotorFixTypeId;
    }

    public Long getSpokeNumber() {
        return spokeNumber;
    }

    public void setSpokeNumber(Long spokeNumber) {
        this.spokeNumber = spokeNumber;
    }

    public CogsetType getCogsetType() {
        return cogsetType;
    }

    public void setCogsetType(CogsetType cogsetType) {
        this.cogsetType = cogsetType;
    }

    public Long getBackSprocketNumber() {
        return backSprocketNumber;
    }

    public void setBackSprocketNumber(Long backSprocketNumber) {
        this.backSprocketNumber = backSprocketNumber;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
