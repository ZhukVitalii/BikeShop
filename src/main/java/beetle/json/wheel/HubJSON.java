package beetle.json.wheel;

import beetle.entity.wheels.RotorFixType;
import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeType;
import beetle.enums.transmission.CogsetType;
import beetle.enums.transmission.HubBindingType;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class HubJSON extends BaseJSON {
    private long id;
    private LocationType location;
    private HubBindingType hubBindingType;
    private String bearingType;
    private Double axisLength;
    private Double axisDiam;
    private BrakeType brakeType;
    private String rotorFixType;
    private Long rotorFixTypeId;
    private int spokeNumber;
    private CogsetType cogsetType;
    private Long backSprocketNumber;

}
