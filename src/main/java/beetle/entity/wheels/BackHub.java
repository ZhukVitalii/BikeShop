package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.forks.BrakesType;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="back_hubs")
@NoArgsConstructor
@Getter
@Setter
public class BackHub {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="fix_type_id")
    private HubFixType hubFixType;
    @ManyToOne
    @JoinColumn(name="bearing_type_id")
    private BearingType bearingType;
    @ManyToOne
    @JoinColumn(name="axis_length_id")
    private AxisLength axisLength;
    @ManyToOne
    @JoinColumn(name="axis_diam_id")
    private AxisDiam axisDiam;
    @ManyToOne
    @JoinColumn(name="brakes_type_id")
    private BrakesType brakesType;
    @ManyToOne
    @JoinColumn(name="rot_fix_id")
    private RotorFixType rotorFixType;
    @ManyToOne
    @JoinColumn(name="spoke_num_id")
    private SpokeNumber spokeNumber;
    @ManyToOne
    @JoinColumn(name="spr_type_id")
    private BackSprocketType backSprocketType;
    @ManyToOne
    @JoinColumn(name="spr_num_id")
    private  BackSprocketNumber backSprocketNumber;

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

    public HubFixType getHubFixType() {
        return hubFixType;
    }

    public void setHubFixType(HubFixType hubFixType) {
        this.hubFixType = hubFixType;
    }

    public BearingType getBearingType() {
        return bearingType;
    }

    public void setBearingType(BearingType bearingType) {
        this.bearingType = bearingType;
    }

    public AxisLength getAxisLength() {
        return axisLength;
    }

    public void setAxisLength(AxisLength axisLength) {
        this.axisLength = axisLength;
    }

    public AxisDiam getAxisDiam() {
        return axisDiam;
    }

    public void setAxisDiam(AxisDiam axisDiam) {
        this.axisDiam = axisDiam;
    }

    public BrakesType getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(BrakesType brakesType) {
        this.brakesType = brakesType;
    }

    public RotorFixType getRotorFixType() {
        return rotorFixType;
    }

    public void setRotorFixType(RotorFixType rotorFixType) {
        this.rotorFixType = rotorFixType;
    }

    public SpokeNumber getSpokeNumber() {
        return spokeNumber;
    }

    public void setSpokeNumber(SpokeNumber spokeNumber) {
        this.spokeNumber = spokeNumber;
    }

    public BackSprocketType getBackSprocketType() {
        return backSprocketType;
    }

    public void setBackSprocketType(BackSprocketType backSprocketType) {
        this.backSprocketType = backSprocketType;
    }

    public BackSprocketNumber getBackSprocketNumber() {
        return backSprocketNumber;
    }

    public void setBackSprocketNumber(BackSprocketNumber backSprocketNumber) {
        this.backSprocketNumber = backSprocketNumber;
    }
}
