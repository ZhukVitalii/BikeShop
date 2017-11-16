package beetle.Entities.Handlebars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */
@Entity
@Table(name="Grips")
@NoArgsConstructor
@Getter
@Setter
public class Grips {
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
    private String weight;
    private String material;
    private String color;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Grips (HandlebarMaker handlebarMaker,Long article,String url, String name, String length, String weight, String material,
                   String color, Double price, String description, String way) {
        this.handlebarMaker = handlebarMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.length = length;
        this.weight = weight;
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
