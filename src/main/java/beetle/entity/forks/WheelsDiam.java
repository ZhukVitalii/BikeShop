package beetle.entity.forks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 30.05.2017.
 */
@Entity
@Table(name="wheels_diams")
@NoArgsConstructor
@Getter
@Setter
public class WheelsDiam {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

//    @OneToMany(mappedBy="wheelsDiam", cascade=CascadeType.ALL)
//    private List<Fork> forks = new ArrayList<Fork>();
//
//    @OneToMany(mappedBy="wheelsDiam", cascade=CascadeType.ALL)
//    private List<Frame> frames = new ArrayList<Frame>();
//
//    @OneToMany (mappedBy="wheelsDiam", cascade= CascadeType.ALL)
//    private List<WheelsDiam> wheelsDiam = new ArrayList<WheelsDiam>();
//
    public WheelsDiam(String diam) {
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
