package beetle.Forks;

import beetle.Frames.Frame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 30.05.2017.
 */
@Entity
@Table(name="WheelsDiams")
@NoArgsConstructor
@Getter
@Setter
public class WheelsDiam {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="wheelsDiam", cascade=CascadeType.ALL)
    private List<Fork> forks = new ArrayList<Fork>();

    @OneToMany(mappedBy="wheelsDiam", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany (mappedBy="wheelsDiam", cascade= CascadeType.ALL)
    private List<WheelsDiam> wheelsDiam = new ArrayList<WheelsDiam>();


    public WheelsDiam(String diam) {
        this.diam = diam;
    }
}
