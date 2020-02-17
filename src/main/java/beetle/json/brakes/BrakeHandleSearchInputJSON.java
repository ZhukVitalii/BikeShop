package beetle.json.brakes;

import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.json.PaggingJSON;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrakeHandleSearchInputJSON extends PaggingJSON {
    private LocationType location;
    private BrakeHandleCompatibilityEnum compatibility;
    private Double handlebarDiameter;
    private String wide;
    private Long manufacturerId;


    @Override
    public String toString() {
        return "BrakeHandleSearchInputJSON{" +
                "location=" + location +
                ", compatibility=" + compatibility +
                ", wide='" + wide + '\'' +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}
