package beetle.entity.forks;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.enums.brakes.BrakeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */

@Entity
@Table(name="forks")
@NoArgsConstructor
@Getter
@Setter
public class Fork extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="whells_d_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="tybe_d_id")
    private TubeDiameter tubeDiameter;
    private String stTubeLength;
    @Enumerated(EnumType.STRING)
    @Column(name="brake_type")
    private BrakeType brakeType;
}
