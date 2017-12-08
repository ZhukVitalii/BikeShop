package beetle.Entities.Handlebars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Entities.Forks.TubeDiameter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 07.06.2017.
 */
@Entity
@Table(name="Stems")
@NoArgsConstructor
@Getter
@Setter
public class Stem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private HandlebarMaker maker;
    private Long article;
    private String url;
    private String name;
    private String angle;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private HandlebarDiameter handlebarDiameter;
    @ManyToOne
    @JoinColumn(name="tube_diam_id")
    private TubeDiameter tubeDiameter;
    private String material;
    private String length;
    private String color;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Stem(HandlebarMaker maker,Long article, String url, String name,String angle,HandlebarDiameter handlebarDiameter, TubeDiameter tubeDiameter,String material,String length,
                   String color, Double price, String description, String way) {
        this.maker = maker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.angle = angle;
        this.handlebarDiameter = handlebarDiameter;
        this.tubeDiameter = tubeDiameter;
        this.material = material;
        this.length = length;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }
    public Double getPrice() {
        return price;
    }

    public HandlebarMaker getMaker() {
        return maker;
    }
}
