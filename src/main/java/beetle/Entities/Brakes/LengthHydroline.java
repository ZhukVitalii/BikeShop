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
@Table(name="LengthHydrolines")
@NoArgsConstructor
@Getter
@Setter
public class LengthHydroline {
    @Id
    @GeneratedValue
    private long id;
    private String length;

    @OneToMany(mappedBy="lengthHydroline", cascade=CascadeType.ALL)
    private List<BrakeDiscHydraulic> brakeDiscHydraulics  = new ArrayList<BrakeDiscHydraulic>();

    @OneToMany(mappedBy="lengthHydroline", cascade= CascadeType.ALL)
    private List<LengthHydroline> lengthHydroline = new ArrayList<LengthHydroline>();

    public LengthHydroline(String length) {
        this.length = length;
    }
}
