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
@Table(name="BackGearKass")
@NoArgsConstructor
@Getter
@Setter
//Касета
public class BackGearKas {
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
    @JoinColumn(name="back_spr_num_id")
    private BackSprocketNumber backSprocketNumber;
    @ManyToOne
    @JoinColumn(name="back_spr_max_id")
    private BackSprocketMax backSprocketMax;
    @ManyToOne
    @JoinColumn(name="back_spr_min_id")
    private BackSprocketMin backSprocketMin;
    @ManyToOne
    @JoinColumn(name="back_spr_size_id")
    private BackSprocketSize backSprocketSize;
    private String material;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BackGearKas (TransmissionMaker transmissionMaker,Long article,String url, String name,BackSprocketNumber backSprocketNumber,BackSprocketMax backSprocketMax,
                        BackSprocketMin backSprocketMin,BackSprocketSize backSprocketSize,String material, String color, String description, Double price,
                       String way) {
        this.transmissionMaker = transmissionMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.backSprocketNumber = backSprocketNumber;
        this.backSprocketMax = backSprocketMax;
        this.backSprocketMin = backSprocketMin;
        this.backSprocketSize = backSprocketSize;
        this.material = material;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
}