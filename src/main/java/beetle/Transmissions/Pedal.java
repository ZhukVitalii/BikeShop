package beetle.Transmissions;

import beetle.Wheels.BearingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="Pedals")
@NoArgsConstructor
@Getter
@Setter
public class Pedal {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private TransmissionMaker transmissionMaker;
    private String name;
    @ManyToOne
    @JoinColumn(name="pedal_type_id")
    private PedalType pedalType;
    @ManyToOne
    @JoinColumn(name="bearing_type_id")
    private BearingType bearingType;
    private String sizes;
    private String material;
    private String weight;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public Pedal(TransmissionMaker transmissionMaker, String name, PedalType pedalType, BearingType bearingType,
                 String sizes, String material,String weight,String color, String description,
                 Double price, String way) {
        this.transmissionMaker = transmissionMaker;
        this.name = name;
        this.pedalType = pedalType;
        this.bearingType = bearingType;
        this.sizes =sizes;
        this.material =material;
        this.weight = weight;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
}