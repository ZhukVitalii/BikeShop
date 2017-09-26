package beetle.Forks;

import beetle.Frames.BikeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */

@Entity
@Table(name="Forks")
@NoArgsConstructor
@Getter
@Setter

public class Fork {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="group_id")
    private ForkMaker forkMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    @ManyToOne
    @JoinColumn(name="whells_d_id")
    private WheelsDiam wheelsDiam;
    @ManyToOne
    @JoinColumn(name="tybe_d_id")
    private TubeDiameter tubeDiameter;
    private String stTubeLength;
    @ManyToOne
    @JoinColumn(name="tybe_br_id")
    private BrakesType brakesType;
    private String forkMaterial;
    private String weight;
    private String color;
    private String move;
    private Double price;
    @Column(name = "description", length = 10000)
    private String description;
    private String way;

    public Fork(ForkMaker forkMaker,Long article,String url, String name, BikeType bikeType, WheelsDiam wheelsDiam, TubeDiameter tubeDiameter,
                String stTubeLength, BrakesType brakesType, String forkMaterial,
                String weight, String color, String move, Double price, String description, String way) {
        this.forkMaker = forkMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.bikeType = bikeType ;
        this.wheelsDiam = wheelsDiam;
        this.tubeDiameter = tubeDiameter;
        this.stTubeLength = stTubeLength;
        this.brakesType = brakesType;
        this.forkMaterial = forkMaterial;
        this.weight = weight;
        this.color = color;
        this.move = move;
        this.price = price;
        this.description = description;
        this.way = way;
    }

}
