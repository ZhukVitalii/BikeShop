package beetle.Entities.Brakes;

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
@Table(name="BrakeMakers")
@NoArgsConstructor
@Getter
@Setter
public class BrakeMaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="brakeMaker", cascade=CascadeType.ALL)
    private List<BrakeVBrake> brakeVBrakes  = new ArrayList<BrakeVBrake>();

    @OneToMany(mappedBy="brakeMaker", cascade=CascadeType.ALL)
    private List<BrakeDiscHydraulic> brakeDiscHydraulics  = new ArrayList<BrakeDiscHydraulic>();

    @OneToMany(mappedBy="brakeMaker", cascade=CascadeType.ALL)
    private List<BrakeDiscMechanik> brakeDiscMechaniks  = new ArrayList<BrakeDiscMechanik>();

    @OneToMany(mappedBy="brakeMaker", cascade= CascadeType.ALL)
    private List<BrakeMaker> brakeMaker = new ArrayList<BrakeMaker>();

    public BrakeMaker(String name) {
        this.name = name;
    }
}