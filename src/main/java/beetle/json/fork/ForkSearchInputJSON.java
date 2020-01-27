package beetle.json.fork;

import beetle.entity.Manufacturer;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.enums.brakes.BrakeType;
import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ForkSearchInputJSON extends PaggingJSON {
    private Long bikeTypeId;
    private Long wheelsDiamId;
    private Long tubeDiameterId;
    private BrakeType brakeType;
    private Long manufacturerId;
}
