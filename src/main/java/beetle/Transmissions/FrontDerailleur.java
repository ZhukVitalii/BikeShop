package beetle.Transmissions;

import beetle.Wheels.BackSprocketNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="FrontDerailleurs")
@NoArgsConstructor
@Getter
@Setter
public class FrontDerailleur {
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
    private String material;
    private String weight;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public FrontDerailleur (TransmissionMaker transmissionMaker, Long article , String url, String name, FrontSprocketNumber frontSprocketNumber,
                            BackSprocketNumber backSprocketNumber, FrontSprocketMax frontSprocketMax,FrontSprocketMin frontSprocketMin, TeethCapasity teethCapasity,
                            String chainLine,FrontDerailleurFixType frontDerailleurFixType, CollarDiam collarDiam,
                            TractionType tractionType,String  material, String weight, String color, String description, Double price, String way) {
        this.transmissionMaker = transmissionMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.frontSprocketNumber = frontSprocketNumber;
        this.backSprocketNumber = backSprocketNumber;
        this.frontSprocketMax = frontSprocketMax;
        this.frontSprocketMin = frontSprocketMin;
        this.teethCapasity = teethCapasity;
        this.chainLine = chainLine;
        this.frontDerailleurFixType = frontDerailleurFixType;
        this.collarDiam = collarDiam;
        this.tractionType = tractionType;
        this.material = material;
        this.weight = weight;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }

    public Double getPrice(){
        return price;
    }
}