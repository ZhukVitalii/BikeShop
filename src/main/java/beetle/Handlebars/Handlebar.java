package beetle.Handlebars;

import beetle.Frames.BikeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="Handlebars")
@NoArgsConstructor
@Getter
@Setter

public class Handlebar {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private HandlebarMaker handlebarMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    private String handlebarWide;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private HandlebarDiameter handlebarDiameter;
    private String handlebarHeight;
    private String material;
    private String weight;
    private String color;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Handlebar(HandlebarMaker handlebarMaker,Long article, String url, String name, BikeType bikeType, String handlebarWide, HandlebarDiameter handlebarDiameter, String handlebarHeight, String material,
                     String weight,String color, Double price, String description, String way) {
        this.handlebarMaker = handlebarMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.bikeType = bikeType;
        this.handlebarWide = handlebarWide;
        this.handlebarDiameter = handlebarDiameter;
        this.handlebarHeight = handlebarHeight;
        this.material = material;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }

}
