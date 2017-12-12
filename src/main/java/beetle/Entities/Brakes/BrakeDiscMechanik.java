package beetle.Entities.Brakes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Entities.Wheels.RotorFixType;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Entity
@Table(name="BrakeDiscMechaniks")
@NoArgsConstructor
@Getter
@Setter
public class BrakeDiscMechanik {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private BrakeMaker maker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="loc_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name="rotor_diam_id")
    private RotorDiam rotorDiam;
    private String rotorWeight;
    private String materialBrake;
    private String brakeWeight;
    @ManyToOne
    @JoinColumn(name="rotor_fix_type_id")
    private RotorFixType rotorFixType;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BrakeDiscMechanik(BrakeMaker maker,Long article,String url, String name, Location location,RotorDiam rotorDiam,String rotorWeight,String materialBrake,
                              String brakeWeight,RotorFixType rotorFixType, String color, String description, Double price, String way) {
        this.maker = maker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.location = location;
        this.rotorDiam = rotorDiam;
        this.rotorWeight = rotorWeight;
        this.materialBrake = materialBrake;
        this.brakeWeight = brakeWeight;
        this.rotorFixType = rotorFixType;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
    public Double getPrice(){
        return price;
    }

    public BrakeMaker getMaker() {
        return maker;
    }

}
