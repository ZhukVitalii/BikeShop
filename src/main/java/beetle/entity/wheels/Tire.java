package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.forks.WheelsDiam;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 25.06.2017.
 */
@Entity
@Table(name="tires")
@NoArgsConstructor
@Getter
@Setter
public class Tire {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="size_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="tire_type_id")
    private TireType tireType;
    @ManyToOne
    @JoinColumn(name="cord_type_id")
    private CordType cordType;
    @ManyToOne
    @JoinColumn(name="tire_wide_id")
    private TireWide tireWide;

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

    public WheelsDiam getWheelsDiam() {
        return wheelsDiam;
    }

    public void setWheelsDiam(WheelsDiam wheelsDiam) {
        this.wheelsDiam = wheelsDiam;
    }

    public TireType getTireType() {
        return tireType;
    }

    public void setTireType(TireType tireType) {
        this.tireType = tireType;
    }

    public CordType getCordType() {
        return cordType;
    }

    public void setCordType(CordType cordType) {
        this.cordType = cordType;
    }

    public TireWide getTireWide() {
        return tireWide;
    }

    public void setTireWide(TireWide tireWide) {
        this.tireWide = tireWide;
    }
}

