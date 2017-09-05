package beetle.Wheels;

import beetle.Bakes.BikeType;
import beetle.Forks.BrakesType;
import beetle.Forks.WheelsDiam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="Wheels")
@NoArgsConstructor
@Getter
@Setter
public class Wheel {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private WheelMaker wheelMaker;
    private String name;
    @ManyToOne
    @JoinColumn(name="size_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="brakes_type_id")
    private BrakesType brakesType;
    @ManyToOne
    @JoinColumn(name="Spoke_num_id")
    private SpokeNumber spokeNumber;
    private String rimName;
    @ManyToOne
    @JoinColumn(name="rim_wide_id")
    private  RimWide rimWide;
    private String rimDescription;
    private String hubName;
    private String hubDescription;
    private String description;
    private Double price;
    private String way;

    public Wheel(WheelMaker wheelMaker, String name, WheelsDiam wheelsDiam,BikeType bikeType, BrakesType brakesType,
                   SpokeNumber spokeNumber, String rimName,RimWide rimWide,String rimDescription,String hubName,
                 String hubDescription, String description, Double price,  String way) {
        this.wheelMaker = wheelMaker;
        this.name = name;
        this.wheelsDiam = wheelsDiam;
        this.bikeType = bikeType ;
        this.brakesType = brakesType;
        this.spokeNumber = spokeNumber;
        this.rimName = rimName;
        this.rimWide = rimWide;
        this.rimDescription=rimDescription;
        this.hubName = hubName;
        this.hubDescription = hubDescription;
        this.description = description;
        this.price = price;
        this.way = way;
    }

}
