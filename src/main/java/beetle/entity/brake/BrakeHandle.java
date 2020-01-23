package beetle.entity.brake;

import beetle.entity.Manufacturer;
import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.enums.brakes.BrakeHandleLocationEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.handlebars.HandlebarDiameter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
@Entity
@Table(name="brake_handles")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandle {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name="location")
    private BrakeHandleLocationEnum location;
    @Enumerated(EnumType.STRING)
    @Column(name="compatibility")
    private BrakeHandleCompatibilityEnum compatibility;
    private String materialHandle;
    private String materialCorp;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private HandlebarDiameter handlebarDiameter;
    @JoinColumn(name="wide")
    private  String wide;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private Manufacturer manufacturer;
    private Long article;
    private String url;
    private String name;
    private String weight;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

}