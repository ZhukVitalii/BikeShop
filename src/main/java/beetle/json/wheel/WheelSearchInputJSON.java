package beetle.json.wheel;

import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeType;
import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WheelSearchInputJSON extends PaggingJSON {
    private String wheelsDiam;
    private Long bikeTypeId;
    private BrakeType brakeType;
    private Long spokeNumber;
    private LocationType location;
    private Long manufacturerId;
}
