package beetle.entity.brake;

import beetle.entity.BaseEntity;
import beetle.enums.brakes.BrakeSubTypeEnum;
import beetle.enums.brakes.BrakeType;
import beetle.enums.LocationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name="brakes")
@Getter
@Setter
@NoArgsConstructor
public class Brake extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "brake_type")
    private BrakeType brakeType;
    @Enumerated(EnumType.STRING)
    @Column(name = "brake_sub_type")
    private BrakeSubTypeEnum brakeSubType;
    @Enumerated(EnumType.STRING)
    private LocationType location;
    @Column(name = "brake_liquid")
    private String brakeLiquid;
    private String materialHandle;
    @Column(name = "length_line")
    private Double lengthHydroline;
    @Column(name = "rotor_diam")
    private Double rotorDiam;
    @Column(name = "rotor_weight")
    private String rotorWeight;
    @Column(name = "rotor_fix_type")
    private String rotorFixType;
}
