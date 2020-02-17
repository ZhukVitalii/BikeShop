package beetle.entity.brake;

import beetle.entity.BaseEntity;
import beetle.enums.LocationType;
import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
@Entity
@Table(name="brake_handles")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandle extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name="location")
    private LocationType location;
    @Enumerated(EnumType.STRING)
    @Column(name="compatibility")
    private BrakeHandleCompatibilityEnum compatibility;
    private String materialCorp;
    @Column(name="")
    private Double handlebarDiameter;
    private  String wide;

}