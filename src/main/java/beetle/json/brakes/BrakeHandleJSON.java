package beetle.json.brakes;

import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.enums.brakes.BrakeHandleLocationEnum;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrakeHandleJSON extends BaseJSON {
    private Long id;
    private BrakeHandleLocationEnum location;
    private BrakeHandleCompatibilityEnum compatibility;
    private String materialHandle;
    private String materialCorp;
    private String handlebarDiameter;
    private String wide;
}
