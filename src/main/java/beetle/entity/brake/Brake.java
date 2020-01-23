package beetle.entity.brake;

import beetle.entity.Manufacturer;
import beetle.enums.brakes.BrakeSubTypeEnum;
import beetle.enums.brakes.BrakeType;
import beetle.enums.brakes.LocationType;

import javax.persistence.*;
@Entity
@Table(name="brakes")
public class Brake {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "brake_type")
    private BrakeType brakeType;
    @Enumerated(EnumType.STRING)
    @Column(name = "brake_sub_type")
    private BrakeSubTypeEnum brakeSubType;
    @Enumerated(EnumType.STRING)
    private LocationType location;
    @Column(name = "brake_liquid")
    private String brakeLiquid;
    private String materialHandle;
    private String material;
    @Column(name = "length_line")
    private Double lengthHydroline;
    @Column(name = "rotor_diam")
    private Double rotorDiam;
    @Column(name = "rotor_weight")
    private String rotorWeight;
    @Column(name = "brake_weight")
    private String brakeWeight;
    @Column(name = "rotor_fix_type")
    private String rotorFixType;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private Manufacturer manufacturer;
    private Long article;
    private String url;
    private String name;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }

    public BrakeSubTypeEnum getBrakeSubType() {
        return brakeSubType;
    }

    public void setBrakeSubType(String brakeSubType) {
        this.brakeSubType = BrakeSubTypeEnum.valueOf(brakeSubType);
    }

    public LocationType getLocation() {
        return location;
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    public String getBrakeLiquid() {
        return brakeLiquid;
    }

    public void setBrakeLiquid(String brakeLiquid) {
        this.brakeLiquid = brakeLiquid;
    }

    public String getMaterialHandle() {
        return materialHandle;
    }

    public void setMaterialHandle(String materialHandle) {
        this.materialHandle = materialHandle;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getLengthHydroline() {
        return lengthHydroline;
    }

    public void setLengthHydroline(Double lengthHydroline) {
        this.lengthHydroline = lengthHydroline;
    }

    public Double getRotorDiam() {
        return rotorDiam;
    }

    public void setRotorDiam(Double rotorDiam) {
        this.rotorDiam = rotorDiam;
    }

    public String getRotorWeight() {
        return rotorWeight;
    }

    public void setRotorWeight(String rotorWeight) {
        this.rotorWeight = rotorWeight;
    }

    public String getBrakeWeight() {
        return brakeWeight;
    }

    public void setBrakeWeight(String brakeWeight) {
        this.brakeWeight = brakeWeight;
    }

    public String getRotorFixType() {
        return rotorFixType;
    }

    public void setRotorFixType(String rotorFixType) {
        this.rotorFixType = rotorFixType;
    }

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
}
