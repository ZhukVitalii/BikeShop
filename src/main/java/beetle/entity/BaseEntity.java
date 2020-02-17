package beetle.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity {
    @ManyToOne
    @JoinColumn(name="maker_id")
    private Manufacturer manufacturer;
    private Long article;
    private String url;
    private String name;
    private String weight;
    private String material;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BaseEntity(Manufacturer manufacturer, Long article, String url, String name, String weight, String material, String color, String description, Double price, String way) {
        this.manufacturer = manufacturer;
        this.article = article;
        this.url = url;
        this.name = name;
        this.weight = weight;
        this.material = material;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
}
