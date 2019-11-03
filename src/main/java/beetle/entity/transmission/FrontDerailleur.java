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
@Table(name="front_derailleurs")
@NoArgsConstructor
@Getter
@Setter
public class FrontDerailleur {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="front_sproc_num_id")
    private FrontSprocketNumber frontSprocketNumber;
    @ManyToOne
    @JoinColumn(name="back_sproc_num_id")
    private BackSprocketNumber backSprocketNumber;
    @ManyToOne
    @JoinColumn(name="front_spr_max_id")
    private FrontSprocketMax frontSprocketMax;
    @ManyToOne
    @JoinColumn(name="front_spr_min_id")
    private FrontSprocketMin frontSprocketMin;
    @ManyToOne
    @JoinColumn(name="teeth_capasity_id") // ємність зубів
    private TeethCapasity teethCapasity;
    private String chainLine;
    @ManyToOne
    @JoinColumn(name="fix_type_id")
    private FrontDerailleurFixType frontDerailleurFixType;
    @ManyToOne
    @JoinColumn(name="collar_diam_id")//діаметр хомута
    private CollarDiam collarDiam;
    @ManyToOne
    @JoinColumn(name="traction_type_id")//тип тяги
    private TractionType tractionType;

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

    public FrontSprocketNumber getFrontSprocketNumber() {
        return frontSprocketNumber;
    }

    public void setFrontSprocketNumber(FrontSprocketNumber frontSprocketNumber) {
        this.frontSprocketNumber = frontSprocketNumber;
    }

    public BackSprocketNumber getBackSprocketNumber() {
        return backSprocketNumber;
    }

    public void setBackSprocketNumber(BackSprocketNumber backSprocketNumber) {
        this.backSprocketNumber = backSprocketNumber;
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

    public TeethCapasity getTeethCapasity() {
        return teethCapasity;
    }

    public void setTeethCapasity(TeethCapasity teethCapasity) {
        this.teethCapasity = teethCapasity;
    }

    public String getChainLine() {
        return chainLine;
    }

    public void setChainLine(String chainLine) {
        this.chainLine = chainLine;
    }

    public FrontDerailleurFixType getFrontDerailleurFixType() {
        return frontDerailleurFixType;
    }

    public void setFrontDerailleurFixType(FrontDerailleurFixType frontDerailleurFixType) {
        this.frontDerailleurFixType = frontDerailleurFixType;
    }

    public CollarDiam getCollarDiam() {
        return collarDiam;
    }

    public void setCollarDiam(CollarDiam collarDiam) {
        this.collarDiam = collarDiam;
    }

    public TractionType getTractionType() {
        return tractionType;
    }

    public void setTractionType(TractionType tractionType) {
        this.tractionType = tractionType;
    }
}