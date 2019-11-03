package beetle.entity.brake;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.handlebars.HandlebarDiameter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
@Entity
@Table(name="brake_handles")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandle {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="loc_id")
    private BrakeHandleLocation brakeHandleLocation;
    @ManyToOne
    @JoinColumn(name="comp_id")
    private BrakeHandleCompatibility brakeHandleCompatibility;
    private String materialHandle;
    private String materialCorp;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private HandlebarDiameter handlebarDiameter;
    @ManyToOne
    @JoinColumn(name="wide_id")
    private  BrakeHandleWide brakeHandleWide;

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

    public BrakeHandleLocation getBrakeHandleLocation() {
        return brakeHandleLocation;
    }

    public void setBrakeHandleLocation(BrakeHandleLocation brakeHandleLocation) {
        this.brakeHandleLocation = brakeHandleLocation;
    }

    public BrakeHandleCompatibility getBrakeHandleCompatibility() {
        return brakeHandleCompatibility;
    }

    public void setBrakeHandleCompatibility(BrakeHandleCompatibility brakeHandleCompatibility) {
        this.brakeHandleCompatibility = brakeHandleCompatibility;
    }

    public String getMaterialHandle() {
        return materialHandle;
    }

    public void setMaterialHandle(String materialHandle) {
        this.materialHandle = materialHandle;
    }

    public String getMaterialCorp() {
        return materialCorp;
    }

    public void setMaterialCorp(String materialCorp) {
        this.materialCorp = materialCorp;
    }

    public HandlebarDiameter getHandlebarDiameter() {
        return handlebarDiameter;
    }

    public void setHandlebarDiameter(HandlebarDiameter handlebarDiameter) {
        this.handlebarDiameter = handlebarDiameter;
    }

    public BrakeHandleWide getBrakeHandleWide() {
        return brakeHandleWide;
    }

    public void setBrakeHandleWide(BrakeHandleWide brakeHandleWide) {
        this.brakeHandleWide = brakeHandleWide;
    }


}