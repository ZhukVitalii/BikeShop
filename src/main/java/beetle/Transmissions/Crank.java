package beetle.Transmissions;

import beetle.Bakes.BikeType;
import beetle.Wheels.BackSprocketNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Entity
@Table(name="Cranks")
@NoArgsConstructor
@Getter
@Setter
public class Crank {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private TransmissionMaker transmissionMaker;
    private Long article;
    private String url;
    private String name;
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
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Crank(TransmissionMaker transmissionMaker, Long article, String url, String name, BikeType bikeType, BackSprocketNumber backSprocketNumber, FrontSprocketNumber frontSprocketNumber,
                 FrontSprocketSize frontSprocketSize,FrontSprocketMax frontSprocketMax,FrontSprocketMin frontSprocketMin,CrankLength crankLength, String sprocketMaterial, String  crankMaterial, BracketType bracketType, String color, String description,
                 Double price, String way) {
        this.transmissionMaker = transmissionMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.bikeType = bikeType;
        this.backSprocketNumber = backSprocketNumber;
        this.frontSprocketNumber = frontSprocketNumber;
        this.frontSprocketSize = frontSprocketSize;
        this.frontSprocketMax = frontSprocketMax;
        this.frontSprocketMin = frontSprocketMin;
        this.crankLength = crankLength;
        this.sprocketMaterial = sprocketMaterial;
        this.crankMaterial = crankMaterial;
        this.bracketType = bracketType;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
}

