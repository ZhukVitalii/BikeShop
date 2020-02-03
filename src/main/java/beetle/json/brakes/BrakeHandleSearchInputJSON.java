package beetle.json.brakes;

import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.json.PaggingJSON;

public class BrakeHandleSearchInputJSON extends PaggingJSON {
    private LocationType location;
    private BrakeHandleCompatibilityEnum compatibility;
    private Long handlebarDiameterId;
    private String wide;
    private Long manufacturerId;

    public LocationType getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = LocationType.valueOf(location);
    }

    public BrakeHandleCompatibilityEnum getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(BrakeHandleCompatibilityEnum compatibility) {
        this.compatibility = compatibility;
    }

    public Long getHandlebarDiameterId() {
        return handlebarDiameterId;
    }

    public void setHandlebarDiameterId(Long handlebarDiameterId) {
        this.handlebarDiameterId = handlebarDiameterId;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "BrakeHandleSearchInputJSON{" +
                "location=" + location +
                ", compatibility=" + compatibility +
                ", handlebarDiameterId=" + handlebarDiameterId +
                ", wide='" + wide + '\'' +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}
