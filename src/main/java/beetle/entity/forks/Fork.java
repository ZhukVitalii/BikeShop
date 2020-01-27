package beetle.entity.forks;

import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.enums.brakes.BrakeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */

@Entity
@Table(name="forks")
@NoArgsConstructor
@Getter
@Setter

public class Fork {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="whells_d_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="tybe_d_id")
    private TubeDiameter tubeDiameter;
    private String stTubeLength;
    @Enumerated(EnumType.STRING)
    @Column(name="brake_type")
    private BrakeType brakeType;

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

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    public WheelsDiam getWheelsDiam() {
        return wheelsDiam;
    }

    public void setWheelsDiam(WheelsDiam wheelsDiam) {
        this.wheelsDiam = wheelsDiam;
    }

    public TubeDiameter getTubeDiameter() {
        return tubeDiameter;
    }

    public void setTubeDiameter(TubeDiameter tubeDiameter) {
        this.tubeDiameter = tubeDiameter;
    }

    public String getStTubeLength() {
        return stTubeLength;
    }

    public void setStTubeLength(String stTubeLength) {
        this.stTubeLength = stTubeLength;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }
}
