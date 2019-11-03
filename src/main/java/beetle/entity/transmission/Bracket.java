package beetle.entity.transmission;

import beetle.entity.Manufacturer;
import beetle.entity.wheels.BearingType;
import beetle.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Entity
@Table(name="brackets")
@NoArgsConstructor
@Getter
@Setter
public class Bracket {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="brac_axis_length_id")
    private BracketAxisLength bracketAxisLength;
    @ManyToOne
    @JoinColumn(name="bracket_wide_id")
    private BracketWide bracketWide;
    @ManyToOne
    @JoinColumn(name="bracket_type_id")
    private BracketType bracketType;
    @ManyToOne
    @JoinColumn(name="bearing_type_id")
    private BearingType bearingType;
    private String axisMaterial;
    @ManyToOne
    @JoinColumn(name="carving_type_id")
    private CarvingType carvingType; // тип різьби

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

    public BracketAxisLength getBracketAxisLength() {
        return bracketAxisLength;
    }

    public void setBracketAxisLength(BracketAxisLength bracketAxisLength) {
        this.bracketAxisLength = bracketAxisLength;
    }

    public BracketWide getBracketWide() {
        return bracketWide;
    }

    public void setBracketWide(BracketWide bracketWide) {
        this.bracketWide = bracketWide;
    }

    public BracketType getBracketType() {
        return bracketType;
    }

    public void setBracketType(BracketType bracketType) {
        this.bracketType = bracketType;
    }

    public BearingType getBearingType() {
        return bearingType;
    }

    public void setBearingType(BearingType bearingType) {
        this.bearingType = bearingType;
    }

    public String getAxisMaterial() {
        return axisMaterial;
    }

    public void setAxisMaterial(String axisMaterial) {
        this.axisMaterial = axisMaterial;
    }

    public CarvingType getCarvingType() {
        return carvingType;
    }

    public void setCarvingType(CarvingType carvingType) {
        this.carvingType = carvingType;
    }
}
