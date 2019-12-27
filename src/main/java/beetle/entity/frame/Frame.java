package beetle.entity.frame;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.BaseEntity;
import beetle.entity.transmission.BracketWide;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="frames")
@NoArgsConstructor
@Getter
@Setter
public class Frame {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="bike_type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="frame_size_id")
    private FrameSize frameSize;
    @ManyToOne
    @JoinColumn(name="whells_d_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="bracket_wide_id")
    private BracketWide bracketWide;
    @ManyToOne
    @JoinColumn(name="headset_type_id")
    private HeadsetType headsetType;
    @ManyToOne
    @JoinColumn(name="tube_diam_id")
    private TubeDiameter tubeDiameter;//труба вилки
    @ManyToOne
    @JoinColumn(name="under_sad_diam_id")
    private UnderSaddleTube underSaddleTube;
    @ManyToOne
    @JoinColumn(name="brakes_type_id")
    private BrakesType brakesType;
    @ManyToOne
    @JoinColumn(name="trunk_id")
    private TrunkBinding trunkBinding;

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

    public Frame(BikeType bikeType, FrameSize frameSize, String name, String description, Double price) {
        this.bikeType = bikeType;
        this.frameSize = frameSize;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Frame() {
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

    public FrameSize getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    public WheelsDiam getWheelsDiam() {
        return wheelsDiam;
    }

    public void setWheelsDiam(WheelsDiam wheelsDiam) {
        this.wheelsDiam = wheelsDiam;
    }

    public BracketWide getBracketWide() {
        return bracketWide;
    }

    public void setBracketWide(BracketWide bracketWide) {
        this.bracketWide = bracketWide;
    }

    public HeadsetType getHeadsetType() {
        return headsetType;
    }

    public void setHeadsetType(HeadsetType headsetType) {
        this.headsetType = headsetType;
    }

    public TubeDiameter getTubeDiameter() {
        return tubeDiameter;
    }

    public void setTubeDiameter(TubeDiameter tubeDiameter) {
        this.tubeDiameter = tubeDiameter;
    }

    public UnderSaddleTube getUnderSaddleTube() {
        return underSaddleTube;
    }

    public void setUnderSaddleTube(UnderSaddleTube underSaddleTube) {
        this.underSaddleTube = underSaddleTube;
    }

    public BrakesType getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(BrakesType brakesType) {
        this.brakesType = brakesType;
    }

    public TrunkBinding getTrunkBinding() {
        return trunkBinding;
    }

    public void setTrunkBinding(TrunkBinding trunkBinding) {
        this.trunkBinding = trunkBinding;
    }

    public long getId() {
        return id;
    }
}