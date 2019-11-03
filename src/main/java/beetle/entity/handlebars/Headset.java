package beetle.entity.handlebars;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.forks.TubeDiameter;

import javax.persistence.*;

@Entity
@Table(name="headsets")
@NoArgsConstructor
@Getter
@Setter
public class Headset{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="type_id")
    private HeadsetType headsetType;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private TubeDiameter tubeDiameter;
    private String size;

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

    public HeadsetType getHeadsetType() {
        return headsetType;
    }

    public void setHeadsetType(HeadsetType headsetType) {
        this.headsetType = headsetType;
    }

    public TubeDiameter getTubeDiameter() {
        return tubeDiameter;
    }

    public void setTubeDiameter(TubeDiameter tubeDiameter) {
        this.tubeDiameter = tubeDiameter;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
