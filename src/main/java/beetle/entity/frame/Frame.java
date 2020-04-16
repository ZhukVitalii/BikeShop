package beetle.entity.frame;

import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="frames")
@NoArgsConstructor
@Getter
@Setter
public class Frame extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="bike_type_id")
    private BikeType bikeType;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name="frame_sizes",
            joinColumns = {@JoinColumn(name = "frame_id")},
            inverseJoinColumns = {@JoinColumn(name = "size_id")}
    )
    private Set<FrameSizeType> frameSizeTypes;
    @ManyToOne
    @JoinColumn(name="whells_d_id")
    private WheelsDiam wheelsDiam;
    @Column(name="bracket_wide")
    private Double bracketWide;
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

}