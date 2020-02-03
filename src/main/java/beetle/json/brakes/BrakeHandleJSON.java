package beetle.json.brakes;

import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrakeHandleJSON extends BaseJSON {
    private Long id;
    private LocationType location;
    private BrakeHandleCompatibilityEnum compatibility;
    private String materialHandle;
    private String materialCorp;
    private String handlebarDiameter;
    private String wide;
}
