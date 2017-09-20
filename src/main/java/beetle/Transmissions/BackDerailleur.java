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
@Table(name="BackDerailleurs")
@NoArgsConstructor
@Getter
@Setter
public class BackDerailleur {
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
    @JoinColumn(name="back_sproc_num_id")
    private BackSprocketNumber backSprocketNumber;
    @ManyToOne
    @JoinColumn(name="back_sproc_max_id")
    private BackSprocketMax backSprocketMax;
    @ManyToOne
    @JoinColumn(name="back_sproc_min_id")
    private BackSprocketMin backSprocketMin;
    @ManyToOne
    @JoinColumn(name="pow_length_id")
    private PawLength pawLength;//довжина лапки
    private String material;
    private String weight;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BackDerailleur (TransmissionMaker transmissionMaker,Long article,String url, String name, BackSprocketNumber backSprocketNumber,
                           BackSprocketMax backSprocketMax, BackSprocketMin backSprocketMin, PawLength pawLength,
                           String  material, String weight, String color, String description, Double price, String way) {
        this.transmissionMaker = transmissionMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.backSprocketNumber = backSprocketNumber;
        this.backSprocketMax = backSprocketMax;
        this.backSprocketMin = backSprocketMin;
        this.pawLength = pawLength;
        this.material = material;
        this.weight = weight;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
}
