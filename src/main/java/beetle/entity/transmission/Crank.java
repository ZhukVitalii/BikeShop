package beetle.entity.transmission;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.BackSprocketNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Entity
@Table(name="cranks")
@NoArgsConstructor
@Getter
@Setter
public class Crank {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="bike_type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="back_sproc_num_id")
    private BackSprocketNumber backSprocketNumber;
    @ManyToOne
    @JoinColumn(name="front_sproc_num_id")
    private FrontSprocketNumber frontSprocketNumber;
    @ManyToOne
    @JoinColumn(name="front_spr_size_id")
    private FrontSprocketSize frontSprocketSize;
    @ManyToOne
    @JoinColumn(name="front_spr_max_id")
    private FrontSprocketMax frontSprocketMax;
    @ManyToOne
    @JoinColumn(name="front_spr_min_id")
    private FrontSprocketMin frontSprocketMin;
    @ManyToOne
    @JoinColumn(name="crank_length_id")
    private CrankLength crankLength;
    private String sprocketMaterial;
    private String crankMaterial;
    @ManyToOne
    @JoinColumn(name="bracket_type_id")
    private BracketType bracketType;


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

    public BackSprocketNumber getBackSprocketNumber() {
        return backSprocketNumber;
    }

    public void setBackSprocketNumber(BackSprocketNumber backSprocketNumber) {
        this.backSprocketNumber = backSprocketNumber;
    }

    public FrontSprocketNumber getFrontSprocketNumber() {
        return frontSprocketNumber;
    }

    public void setFrontSprocketNumber(FrontSprocketNumber frontSprocketNumber) {
        this.frontSprocketNumber = frontSprocketNumber;
    }

    public FrontSprocketSize getFrontSprocketSize() {
        return frontSprocketSize;
    }

    public void setFrontSprocketSize(FrontSprocketSize frontSprocketSize) {
        this.frontSprocketSize = frontSprocketSize;
    }

    public FrontSprocketMax getFrontSprocketMax() {
        return frontSprocketMax;
    }

    public void setFrontSprocketMax(FrontSprocketMax frontSprocketMax) {
        this.frontSprocketMax = frontSprocketMax;
    }

    public FrontSprocketMin getFrontSprocketMin() {
        return frontSprocketMin;
    }

    public void setFrontSprocketMin(FrontSprocketMin frontSprocketMin) {
        this.frontSprocketMin = frontSprocketMin;
    }

    public CrankLength getCrankLength() {
        return crankLength;
    }

    public void setCrankLength(CrankLength crankLength) {
        this.crankLength = crankLength;
    }

    public String getSprocketMaterial() {
        return sprocketMaterial;
    }

    public void setSprocketMaterial(String sprocketMaterial) {
        this.sprocketMaterial = sprocketMaterial;
    }

    public String getCrankMaterial() {
        return crankMaterial;
    }

    public void setCrankMaterial(String crankMaterial) {
        this.crankMaterial = crankMaterial;
    }

    public BracketType getBracketType() {
        return bracketType;
    }

    public void setBracketType(BracketType bracketType) {
        this.bracketType = bracketType;
    }
}

