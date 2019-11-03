package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="wheels")
@NoArgsConstructor
@Getter
@Setter
public class Wheel {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="size_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="brakes_type_id")
    private BrakesType brakesType;
    @ManyToOne
    @JoinColumn(name="Spoke_num_id")
    private SpokeNumber spokeNumber;
    private String rimName;
    @ManyToOne
    @JoinColumn(name="rim_wide_id")
    private  RimWide rimWide;
    @Column(name = "rimDescription", length = 10000)
    private String rimDescription;
    private String hubName;
    @Column(name = "hubDescription", length = 10000)
    private String hubDescription;

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

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    public BrakesType getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(BrakesType brakesType) {
        this.brakesType = brakesType;
    }

    public SpokeNumber getSpokeNumber() {
        return spokeNumber;
    }

    public void setSpokeNumber(SpokeNumber spokeNumber) {
        this.spokeNumber = spokeNumber;
    }

    public String getRimName() {
        return rimName;
    }

    public void setRimName(String rimName) {
        this.rimName = rimName;
    }

    public RimWide getRimWide() {
        return rimWide;
    }

    public void setRimWide(RimWide rimWide) {
        this.rimWide = rimWide;
    }

    public String getRimDescription() {
        return rimDescription;
    }

    public void setRimDescription(String rimDescription) {
        this.rimDescription = rimDescription;
    }

    public String getHubName() {
        return hubName;
    }

    public void setHubName(String hubName) {
        this.hubName = hubName;
    }

    public String getHubDescription() {
        return hubDescription;
    }

    public void setHubDescription(String hubDescription) {
        this.hubDescription = hubDescription;
    }
}
