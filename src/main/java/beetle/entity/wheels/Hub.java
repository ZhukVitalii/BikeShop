package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.forks.BrakesType;
import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeType;
import beetle.enums.transmission.CogsetType;
import beetle.enums.transmission.HubBindingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hub")
@Getter
@Setter
@NoArgsConstructor
public class Hub extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private LocationType location;
    @Enumerated(EnumType.STRING)
    @Column(name="hub_binding_type")
    private HubBindingType hubBindingType;
    @Column(name="bearing_type")
    private String bearingType;
    @Column(name="axis_length")
    private Double axisLength;
    @Column(name="axis_diam")
    private Double axisDiam;
    @Enumerated(EnumType.STRING)
    @Column(name="brake_type")
    private BrakeType brakeType;
    @ManyToOne
    @JoinColumn(name="rot_fix_id")
    private RotorFixType rotorFixType;
    @Column(name="spoke_number")
    private Long spokeNumber;
    @Enumerated(EnumType.STRING)
    @Column(name="cogset_type")
    private CogsetType cogsetType;
    @Column(name="sprocket_number")
    private Long backSprocketNumber;

}
