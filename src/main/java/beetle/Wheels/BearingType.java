package beetle.Wheels;

import beetle.Transmissions.Bracket;
import beetle.Transmissions.Pedal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="BearingTypes")
@NoArgsConstructor
@Getter
@Setter
public class BearingType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="bearingType", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="bearingType", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="bearingType", cascade=CascadeType.ALL)
    private List<Pedal> pedals  = new ArrayList<Pedal>();

    @OneToMany(mappedBy="bearingType", cascade=CascadeType.ALL)
    private List<Bracket> brackets  = new ArrayList<Bracket>();

    @OneToMany(mappedBy="bearingType", cascade= CascadeType.ALL)
    private List<BearingType> bearingType = new ArrayList<BearingType>();

    public BearingType(String type) {
        this.type = type;
    }
}