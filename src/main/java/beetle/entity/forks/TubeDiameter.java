package beetle.entity.forks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 30.05.2017.
 */
@Entity
@Table(name="tube_diameters")
@NoArgsConstructor
@Getter
@Setter
public class TubeDiameter {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

////    @OneToMany(mappedBy="tubeDiameter", cascade=CascadeType.ALL)
////    private List<Fork> forks = new ArrayList<Fork>();
////
////    @OneToMany(mappedBy="tubeDiameter", cascade=CascadeType.ALL)
////    private List<Frame> frames = new ArrayList<Frame>();
////
////    @OneToMany (mappedBy="tubeDiameter", cascade= CascadeType.ALL)
////    private List<TubeDiameter> tubeDiameter = new ArrayList<TubeDiameter>();
//
    public TubeDiameter(String diam) {
        this.diam = diam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiam() {
        return diam;
    }

    public void setDiam(String diam) {
        this.diam = diam;
    }
}
