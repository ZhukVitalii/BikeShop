package beetle.Entities.Transmission;

import beetle.Entities.Wheels.BackSprocketNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="BackGearTrs")
@NoArgsConstructor
@Getter
@Setter
//Трещітка
public class BackGearTr {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private TransmissionMaker maker;
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

    public BackGearTr (TransmissionMaker maker,Long article,String url, String name,BackSprocketNumber backSprocketNumber,BackSprocketMax backSprocketMax,
                       BackSprocketMin backSprocketMin,BackSprocketSize backSprocketSize,String material, String color, String description, Double price,
                       String way) {
        this.maker = maker;
        this.article = article;
        this.url=url;
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

    public Double getPrice(){
        return price;
    }
}