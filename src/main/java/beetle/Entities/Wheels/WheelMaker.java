package beetle.Entities.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="WheelMakers")
@NoArgsConstructor
@Getter
@Setter
public class WheelMaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="wheelMaker", cascade=CascadeType.ALL)
    private List<Wheel> wheels = new ArrayList<Wheel>();

    @OneToMany(mappedBy="wheelMaker", cascade=CascadeType.ALL)
    private List<Spoke> spokes = new ArrayList<Spoke>();

    @OneToMany(mappedBy="wheelMaker", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="wheelMaker", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="wheelMaker", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="wheelMaker", cascade= CascadeType.ALL)
    private List<WheelMaker> wheelMaker = new ArrayList<WheelMaker>();


    public WheelMaker(String name) {
        this.name = name;
    }
}
