package beetle.json.wheel;

import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeType;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class WheelJSON extends BaseJSON {
    private long id;
    private String wheelsDiam;
    private String bikeType;
    private BrakeType brakeType;
    private int spokeNumber;
    private String rimName;
    private Double rimWide;
    private String rimDescription;
    private String hubName;
    private String hubDescription;
    private LocationType location;
}
