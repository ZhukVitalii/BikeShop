package beetle.Entities.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="Spokes")
@NoArgsConstructor
@Getter
@Setter
public class Spoke {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private WheelMaker wheelMaker;
    private Long article;
    private String url;
    private String name;
    private String length;
    private String diameter;
    private String material;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Spoke (WheelMaker wheelMaker,Long article, String url, String name, String length, String diameter, String material,
                  String color,String description, Double price,  String way) {
        this.wheelMaker = wheelMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.length = length;
        this.diameter = diameter;
        this.material = material;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }
    public Double getPrice(){
        return price;
    }

}
