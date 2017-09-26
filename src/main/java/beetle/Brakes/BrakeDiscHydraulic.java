package beetle.Brakes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Wheels.RotorFixType;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Entity
@Table(name="BrakeDiscHydraulics")
@NoArgsConstructor
@Getter
@Setter
public class BrakeDiscHydraulic {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private BrakeMaker brakeMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="loc_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name="brake_liquid_id")
    private  BrakeLiquid brakeLiquid;
    private String materialHandle;
    @ManyToOne
    @JoinColumn(name="length_line_id")
    private LengthHydroline lengthHydroline;
    @ManyToOne
    @JoinColumn(name="rotor_diam_id")
    private  RotorDiam rotorDiam;
    private String rotorWeight;
    private String material;
    private String brakeWeight;
    @ManyToOne
    @JoinColumn(name="rotor_fix_type_id")
    private RotorFixType rotorFixType;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BrakeDiscHydraulic(BrakeMaker brakeMaker,Long article,String url, String name, Location location,BrakeLiquid brakeLiquid, String materialHandle,
                              LengthHydroline lengthHydroline,RotorDiam rotorDiam,String rotorWeight,String material,
                              String brakeWeight,RotorFixType rotorFixType, String color, String description, Double price, String way) {
        this.brakeMaker = brakeMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.location = location;
        this.brakeLiquid = brakeLiquid;
        this.materialHandle = materialHandle;
        this.lengthHydroline = lengthHydroline;
        this.rotorDiam = rotorDiam;
        this.rotorWeight = rotorWeight;
        this.material = material;
        this.brakeWeight = brakeWeight;
        this.rotorFixType = rotorFixType;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
}