package beetle.json.wheel;

import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.enums.brakes.BrakeType;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.management.LockInfo;

@Getter
@Setter
public class RimJSON extends BaseJSON {
    private Long id;
    private String bikeType;
    private Long bikeTypeId;
    private String wheelsDiam;
    private Long wheelsDiamId;
    private String etrtoSize;
    private int spokeNumber;
    private Double innerTubeDiameter;
    private Double rimWide;
    private Double rimHeight;
    private BrakeType brakeType;
}
