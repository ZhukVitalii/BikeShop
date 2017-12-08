package beetle.Entities.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Entities.Forks.WheelsDiam;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 25.06.2017.
 */
@Entity
@Table(name="Tires")
@NoArgsConstructor
@Getter
@Setter
public class Tire {
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
    @JoinColumn(name="tire_type_id")
    private TireType tireType;
    @ManyToOne
    @JoinColumn(name="cord_type_id")
    private CordType cordType;
    @ManyToOne
    @JoinColumn(name="tire_wide_id")
    private TireWide tireWide;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Tire (WheelMaker maker,Long article,String url, String name, WheelsDiam wheelsDiam, TireType tireType, CordType cordType,
                 TireWide tireWide, String color,String description, Double price,  String way) {
        this.maker = maker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.wheelsDiam = wheelsDiam;
        this.tireType = tireType;
        this.cordType = cordType;
        this.tireWide = tireWide;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
    public Double getPrice(){
        return price;
    }

}

