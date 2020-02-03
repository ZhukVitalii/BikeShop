package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;
import beetle.enums.brakes.BrakeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 14.06.2017.
 */
@Entity
@Table(name="rims")
@NoArgsConstructor
@Getter
@Setter
public class Rim extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="wheels_diam_id")
    private WheelsDiam wheelsDiam;
    @Column(name="etrto_size")
    private String etrtoSize;
    @Column(name="spoke_number")
    private int spokeNumber;
    @Column(name="inner_tube_diam")
    private Double innerTubeDiameter;
    @Column(name="rim_wide")
    private Double rimWide;
    @Column(name="rim_height")
    private Double rimHeight;
    @Enumerated(EnumType.STRING)
    @Column(name="brake_type")
    private BrakeType brakeType;
    @Column(name="nipple")
    private String nipple;
}

