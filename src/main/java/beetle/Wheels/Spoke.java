package beetle.Wheels;

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
    private String name;
    private String length;
    private String diameter;
    private String material;
    private String color;
    private String description;
    private Double price;
    private String way;

    public Spoke (WheelMaker wheelMaker, String name, String length, String diameter, String material,
                  String color,String description, Double price,  String way) {
        this.wheelMaker = wheelMaker;
        this.name = name;
        this.length = length;
        this.diameter = diameter;
        this.material = material;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }

}
