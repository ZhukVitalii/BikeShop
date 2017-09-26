package beetle.Wheels;

import beetle.Frames.BikeType;
import beetle.Forks.BrakesType;
import beetle.Forks.WheelsDiam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 14.06.2017.
 */
@Entity
@Table(name="Rims")
@NoArgsConstructor
@Getter
@Setter
public class Rim {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private WheelMaker wheelMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="wheels_diam_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="etrto_id")
    private EtrtoSize etrtoSize;
    private String material;
    @ManyToOne
    @JoinColumn(name="Spoke_num_id")
    private SpokeNumber spokeNumber;
    @ManyToOne
    @JoinColumn(name="inner_tube_id")
    private InnerTubeDiameter innerTubeDiameter;
    @ManyToOne
    @JoinColumn(name="rim_wide_id")
    private  RimWide rimWide;
    @ManyToOne
    @JoinColumn(name="rim_height_id")
    private  RimHeight rimHeight;
    @ManyToOne
    @JoinColumn(name="bra_type_id")
    private BrakesType brakesType;
    private String weight;
    @ManyToOne
    @JoinColumn(name="nipple_id")
    private Nipple nipple;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Rim(WheelMaker wheelMaker,Long article, String url, String name, BikeType bikeType,WheelsDiam wheelsDiam,EtrtoSize etrtoSize, String material,
                 SpokeNumber spokeNumber, InnerTubeDiameter innerTubeDiameter,RimWide rimWide,RimHeight rimHeight,BrakesType brakesType,
               String weight,Nipple nipple,String color, String description, Double price,  String way) {
        this.wheelMaker = wheelMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.bikeType = bikeType;
        this.wheelsDiam = wheelsDiam;
        this.etrtoSize = etrtoSize;
        this.material = material;
        this.spokeNumber = spokeNumber;
        this.innerTubeDiameter = innerTubeDiameter;
        this.rimWide = rimWide;
        this.rimHeight=rimHeight;
        this.brakesType = brakesType;
        this.weight = weight;
        this.nipple = nipple;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }

}

