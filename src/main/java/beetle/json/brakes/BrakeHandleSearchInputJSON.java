package beetle.json.brakes;

import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.enums.brakes.BrakeHandleLocationEnum;
import beetle.json.PaggingJSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BrakeHandleSearchInputJSON extends PaggingJSON {
    private BrakeHandleLocationEnum location;
    private BrakeHandleCompatibilityEnum compatibility;
    private Long handlebarDiameterId;
    private String wide;
    private Long manufacturerId;

    public BrakeHandleLocationEnum getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = BrakeHandleLocationEnum.valueOf(location);
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
