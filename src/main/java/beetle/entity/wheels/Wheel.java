package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;
import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="wheels")
@NoArgsConstructor
@Getter
@Setter
public class Wheel extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="wheels_diam")
    private String wheelsDiam;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @Enumerated(EnumType.STRING)
    @Column(name="brake_type")
    private BrakeType brakeType;
    @Column(name="spoke_number")
    private int spokeNumber;
    @Column(name="rim_name")
    private String rimName;
    @Column(name="rim_wide")
    private  Double rimWide;
    @Column(name = "rim_description", length = 10000)
    private String rimDescription;
    @Column(name="hub_name")
    private String hubName;
    @Column(name = "hub_description", length = 10000)
    private String hubDescription;
    @Enumerated(EnumType.STRING)
    @Column(name="location")
    private LocationType location;

}
