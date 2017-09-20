package beetle.Handlebars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 04.06.2017.
 */
@Entity
@Table(name="Windings")
@NoArgsConstructor
@Getter
@Setter
public class Winding {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private HandlebarMaker handlebarMaker;
    private Long article;
    private String url;
    private String name;
    private String length;
    private String wide;
    private String material;
    private String color;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Winding(HandlebarMaker handlebarMaker,Long article, String url, String name, String length, String wide, String material,
                     String color, Double price, String description, String way) {
        this.handlebarMaker = handlebarMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.length = length;
        this.wide = wide;
        this.material = material;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }

}
