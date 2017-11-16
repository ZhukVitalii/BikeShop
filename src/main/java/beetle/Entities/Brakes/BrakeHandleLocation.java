package beetle.Entities.Brakes;

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
@Table(name="BrakeHandleLocations")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandleLocation {
    @Id
    @GeneratedValue
    private long id;
    private String local;

    @OneToMany(mappedBy="brakeHandleLocation", cascade=CascadeType.ALL)
    private List<BrakeHandle> brakeHandles  = new ArrayList<BrakeHandle>();

    @OneToMany(mappedBy="brakeHandleLocation", cascade= CascadeType.ALL)
    private List<BrakeHandleLocation> brakeHandleLocation= new ArrayList<BrakeHandleLocation>();

    public BrakeHandleLocation(String local) {
        this.local = local;
    }
}
