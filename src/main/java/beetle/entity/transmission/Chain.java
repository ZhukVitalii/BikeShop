package beetle.entity.transmission;

import beetle.entity.Manufacturer;
import beetle.entity.wheels.BackSprocketNumber;
import beetle.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="chains")
@NoArgsConstructor
@Getter
@Setter
//Ланцюг
public class Chain {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="back_spr_num_id")
    private BackSprocketNumber backSprocketNumber;
    @ManyToOne
    @JoinColumn(name="elem_num_id")
    private ChainElementNumber chainElementNumber;

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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BackSprocketNumber getBackSprocketNumber() {
        return backSprocketNumber;
    }

    public void setBackSprocketNumber(BackSprocketNumber backSprocketNumber) {
        this.backSprocketNumber = backSprocketNumber;
    }

    public ChainElementNumber getChainElementNumber() {
        return chainElementNumber;
    }

    public void setChainElementNumber(ChainElementNumber chainElementNumber) {
        this.chainElementNumber = chainElementNumber;
    }
}
