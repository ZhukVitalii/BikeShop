package beetle.Transmissions;

import beetle.Wheels.BearingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Entity
@Table(name="Brackets")
@NoArgsConstructor
@Getter
@Setter
public class Bracket {
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
    @JoinColumn(name="brac_axis_length_id")
    private BracketAxisLength bracketAxisLength;
    @ManyToOne
    @JoinColumn(name="bracket_wide_id")
    private BracketWide bracketWide;
    @ManyToOne
    @JoinColumn(name="bracket_type_id")
    private BracketType bracketType;
    @ManyToOne
    @JoinColumn(name="bearing_type_id")
    private BearingType bearingType;
    private String axisMaterial;
    @ManyToOne
    @JoinColumn(name="carving_type_id")
    private CarvingType carvingType; // тип різьби
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Bracket (TransmissionMaker transmissionMaker, Long article, String url, String name, BracketAxisLength bracketAxisLength, BracketWide bracketWide, BracketType bracketType,
                    BearingType bearingType, String axisMaterial, CarvingType carvingType, String color, String description,
                    Double price, String way) {
        this.transmissionMaker = transmissionMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.bracketAxisLength = bracketAxisLength;
        this.bracketWide = bracketWide;
        this.bracketType = bracketType;
        this.bearingType = bearingType;
        this.axisMaterial = axisMaterial;
        this.carvingType = carvingType;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }

    public BracketType getBracketType() {
        return bracketType;
    }

    public Double getPrice(){
        return price;
    }
}
