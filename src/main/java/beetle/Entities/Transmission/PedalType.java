package beetle.Entities.Transmission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="PedalTypes")
@NoArgsConstructor
@Getter
@Setter
public class PedalType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="pedalType", cascade=CascadeType.ALL)
    private List<Pedal> pedals  = new ArrayList<Pedal>();

    @OneToMany(mappedBy="pedalType", cascade= CascadeType.ALL)
    private List<PedalType> pedalType = new ArrayList<PedalType>();

    public PedalType (String type) {
        this.type = type;
    }
}