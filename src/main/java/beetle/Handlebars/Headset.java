package beetle.Handlebars;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Forks.TubeDiameter;

import javax.persistence.*;

@Entity
@Table(name="Headsets")
@NoArgsConstructor
@Getter
@Setter
public class Headset {
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
    private HeadsetType headsetType;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private TubeDiameter tubeDiameter;
    private String material;
    private String size;
    private String color;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Headset(HandlebarMaker handlebarMaker,Long article, String url, String name, HeadsetType headsetType,TubeDiameter tubeDiameter, String material,
                   String size, String color, Double price, String description, String way) {
        this.handlebarMaker = handlebarMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.headsetType = headsetType;
        this.tubeDiameter = tubeDiameter;
        this.material = material;
        this.size = size;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }

}
