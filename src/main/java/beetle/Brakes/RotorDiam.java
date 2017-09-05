package beetle.Brakes;

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
@Table(name="RotorDiams")
@NoArgsConstructor
@Getter
@Setter
public class RotorDiam {
    @Id
    @GeneratedValue
    private long id;
    private String diam;



    @OneToMany(mappedBy="rotorDiam", cascade=CascadeType.ALL)
    private List<BrakeDiscHydraulic> brakeDiscHydraulics  = new ArrayList<BrakeDiscHydraulic>();

    @OneToMany(mappedBy="rotorDiam", cascade=CascadeType.ALL)
    private List<BrakeDiscMechanik> brakeDiscMechaniks  = new ArrayList<BrakeDiscMechanik>();





    @OneToMany(mappedBy="rotorDiam", cascade= CascadeType.ALL)
    private List<RotorDiam> rotorDiam = new ArrayList<RotorDiam>();


    public RotorDiam(String diam) {
        this.diam = diam;
    }
}
