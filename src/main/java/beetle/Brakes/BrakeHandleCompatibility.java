package beetle.Brakes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
@Entity
@Table(name="BrakeHandleCompatibilitys")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandleCompatibility {
    @Id
    @GeneratedValue
    private long id;
    private String comp;

    @OneToMany(mappedBy="brakeHandleCompatibility", cascade=CascadeType.ALL)
    private List<BrakeHandle> brakeHandles  = new ArrayList<BrakeHandle>();

    @OneToMany(mappedBy="brakeHandleCompatibility", cascade= CascadeType.ALL)
    private List<BrakeHandleCompatibility> brakeHandleCompatibility= new ArrayList<BrakeHandleCompatibility>();

    public BrakeHandleCompatibility(String comp) {
        this.comp = comp;
    }
}
