package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.forks.WheelsDiam;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 25.06.2017.
 */
@Entity
@Table(name="tires")
@NoArgsConstructor
@Getter
@Setter
public class Tire extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="size_id")
    private WheelsDiam wheelsDiam;
    @Column(name="tire_type")
    private String tireType;
    @Column(name="cord_type")
    private String cordType;
    @Column(name="tire_wide")
    private Double tireWide;
}

