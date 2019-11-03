package beetle.entity.brake;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.wheels.RotorFixType;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Entity
@Table(name="brake_disc_mechaniks")
@NoArgsConstructor
@Getter
@Setter
public class BrakeDiscMechanik {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="loc_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name="rotor_diam_id")
    private  RotorDiam rotorDiam;
    private String rotorWeight;
    private String materialBrake;
    private String brakeWeight;
    @ManyToOne
    @JoinColumn(name="rotor_fix_type_id")
    private RotorFixType rotorFixType;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RotorDiam getRotorDiam() {
        return rotorDiam;
    }

    public void setRotorDiam(RotorDiam rotorDiam) {
        this.rotorDiam = rotorDiam;
    }

    public String getRotorWeight() {
        return rotorWeight;
    }

    public void setRotorWeight(String rotorWeight) {
        this.rotorWeight = rotorWeight;
    }

    public String getMaterialBrake() {
        return materialBrake;
    }

    public void setMaterialBrake(String materialBrake) {
        this.materialBrake = materialBrake;
    }

    public String getBrakeWeight() {
        return brakeWeight;
    }

    public void setBrakeWeight(String brakeWeight) {
        this.brakeWeight = brakeWeight;
    }

    public RotorFixType getRotorFixType() {
        return rotorFixType;
    }

    public void setRotorFixType(RotorFixType rotorFixType) {
        this.rotorFixType = rotorFixType;
    }

}
