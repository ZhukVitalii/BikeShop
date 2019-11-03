package beetle.entity.brake;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Entity
@Table(name="Locations")
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String local;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<BrakeVBrake> brakeVBrakes  = new ArrayList<BrakeVBrake>();

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<BrakeDiscHydraulic> brakeDiscHydraulics  = new ArrayList<BrakeDiscHydraulic>();

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<BrakeDiscMechanik> brakeDiscMechaniks  = new ArrayList<BrakeDiscMechanik>();

    @OneToMany(mappedBy="location", cascade= CascadeType.ALL)
    private List<Location> location = new ArrayList<Location>();

    public Location(String local) {
        this.local = local;
    }
}