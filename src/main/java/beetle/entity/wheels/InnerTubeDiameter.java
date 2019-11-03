package beetle.entity.wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 15.06.2017.
 */
@Entity
@Table(name="inner_tube_diameters")
@NoArgsConstructor
@Getter
@Setter
public class InnerTubeDiameter {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="innerTubeDiameter", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="innerTubeDiameter", cascade= CascadeType.ALL)
    private List<InnerTubeDiameter> innerTubeDiameter = new ArrayList<InnerTubeDiameter>();

    public InnerTubeDiameter(String diam) {
        this.diam = diam;
    }
}