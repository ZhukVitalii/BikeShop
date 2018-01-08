package beetle.Entities.Wheels;

import beetle.Entities.Frames.BikeType;
import beetle.Entities.Forks.BrakesType;
import beetle.Entities.Forks.WheelsDiam;
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
    private WheelMaker maker;
    private Long article;
    private String url;
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
    @Column(name = "rimDescription", length = 10000)
    private String rimDescription;
    private String hubName;
    @Column(name = "hubDescription", length = 10000)
    private String hubDescription;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Wheel(WheelMaker maker,Long article, String url, String name, WheelsDiam wheelsDiam,BikeType bikeType, BrakesType brakesType,
                   SpokeNumber spokeNumber, String rimName,RimWide rimWide,String rimDescription,String hubName,
                 String hubDescription, String description, Double price,  String way) {
        this.maker = maker;
        this.article = article;
        this.url = url;
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
    public Double getPrice(){
        return price;
    }
    public WheelMaker getMaker() {
        return maker;
    }

}
