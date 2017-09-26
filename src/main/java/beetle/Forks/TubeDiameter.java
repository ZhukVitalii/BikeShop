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
@Table(name="TubeDiameters")
@NoArgsConstructor
@Getter
@Setter
public class TubeDiameter {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="tubeDiameter", cascade=CascadeType.ALL)
    private List<Fork> forks = new ArrayList<Fork>();

    @OneToMany(mappedBy="tubeDiameter", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany (mappedBy="tubeDiameter", cascade= CascadeType.ALL)
    private List<TubeDiameter> tubeDiameter = new ArrayList<TubeDiameter>();

    public TubeDiameter(String diam) {
        this.diam = diam;
    }
}
