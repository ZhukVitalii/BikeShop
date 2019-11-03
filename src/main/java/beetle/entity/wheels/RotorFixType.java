package beetle.entity.wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.brake.BrakeDiscHydraulic;
import beetle.entity.brake.BrakeDiscMechanik;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="rotor_fix_types")
@NoArgsConstructor
@Getter
@Setter
public class RotorFixType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="rotorFixType", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="rotorFixType", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="rotorFixType", cascade=CascadeType.ALL)
    private List<BrakeDiscHydraulic> brakeDiscHydraulics  = new ArrayList<BrakeDiscHydraulic>();

    @OneToMany(mappedBy="rotorFixType", cascade=CascadeType.ALL)
    private List<BrakeDiscMechanik> brakeDiscMechaniks  = new ArrayList<BrakeDiscMechanik>();

    @OneToMany(mappedBy="rotorFixType", cascade= CascadeType.ALL)
    private List<RotorFixType> rotorFixType = new ArrayList<RotorFixType>();

    public RotorFixType(String type) {
        this.type = type;
    }
}