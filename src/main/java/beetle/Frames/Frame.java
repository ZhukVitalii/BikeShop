package beetle.Frames;

import beetle.Forks.BrakesType;
import beetle.Forks.TubeDiameter;
import beetle.Forks.WheelsDiam;
import beetle.Handlebars.HeadsetType;
import beetle.Transmissions.BracketWide;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Frames")
@NoArgsConstructor
@Getter
@Setter
public class Frame {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private FrameMaker frameMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="bike_type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="frame_size_id")
    private FrameSize frameSize;
    @ManyToOne
    @JoinColumn(name="whells_d_id")
    private WheelsDiam wheelsDiam;
    private String material;
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
    private String weight;
    private String color;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Frame(FrameMaker frameMaker,Long article,String url, String name, BikeType bikeType, FrameSize frameSize,WheelsDiam wheelsDiam, String material, BracketWide bracketWide,
                 HeadsetType headsetType, TubeDiameter tubeDiameter, UnderSaddleTube underSaddleTube, BrakesType brakesType,
                 TrunkBinding trunkBinding, String weight, String color, Double price,String description, String way) {
        this.frameMaker = frameMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.bikeType =bikeType;
        this.frameSize = frameSize;
        this.wheelsDiam = wheelsDiam;
        this.material = material;
        this.bracketWide = bracketWide;
        this.headsetType = headsetType;
        this.tubeDiameter = tubeDiameter;
        this.underSaddleTube = underSaddleTube;
        this.brakesType = brakesType;
        this.trunkBinding = trunkBinding;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.description = description;
        this.way = way;
    }

    public Double getPrice() {
        return price;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public WheelsDiam getWheelsDiam() {
        return wheelsDiam;
    }

    public TubeDiameter getTubeDiameter() {
        return tubeDiameter;
    }

    public BrakesType getBrakesType() {
        return brakesType;
    }

    public BracketWide getBracketWide() {
        return bracketWide;
    }

    public Long getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }
}