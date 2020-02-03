package beetle.json.wheel;

import beetle.enums.brakes.BrakeType;
import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RimSearchInputJSON extends PaggingJSON {
    private Long bikeTypeId;
    private Long wheelsDiamId;
    private Long spokeNumber;
    private Double rimWide;
    private Double rimHeight;
    private BrakeType brakeType;
    private Long manufacturerId;
}
