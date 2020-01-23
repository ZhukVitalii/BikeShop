package beetle.json.frame;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.transmission.BracketWide;
import beetle.entity.frame.*;

import java.io.Serializable;

public class FrameSearchParams implements Serializable {
    private long id;
    private Manufacturer frameMaker;
    private Long article;
    private String url;
    private String name;
    private BikeType bikeType;
    private FrameSize frameSize;
    private WheelsDiam wheelsDiam;
    private String material;
    private BracketWide bracketWide;
    private HeadsetType headsetType;
    private TubeDiameter tubeDiameter;//труба вилки
    private UnderSaddleTube underSaddleTube;
    private BrakesType brakesType;
    private TrunkBinding trunkBinding;
    private String weight;
    private String color;
    private Double price;
    private String description;
    private String way;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manufacturer getFrameMaker() {
        return frameMaker;
    }

    public void setFrameMaker(Manufacturer frameMaker) {
        this.frameMaker = frameMaker;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
