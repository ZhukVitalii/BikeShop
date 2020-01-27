package beetle.json.fork;

import beetle.enums.brakes.BrakeType;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForkJSON extends BaseJSON {

    private long id;
    private String bikeType;
    private String wheelsDiam;
    private String tubeDiameter;
    private String stTubeLength;
    private BrakeType brakeType;
}
