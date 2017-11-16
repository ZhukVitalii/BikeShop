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
@Table(name="BrakeHandleWides")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandleWide {
    @Id
    @GeneratedValue
    private long id;
    private String wide;

    @OneToMany(mappedBy="brakeHandleWide", cascade=CascadeType.ALL)
    private List<BrakeHandle> brakeHandles  = new ArrayList<BrakeHandle>();

    @OneToMany(mappedBy="brakeHandleWide", cascade= CascadeType.ALL)
    private List<BrakeHandleWide> brakeHandleWide= new ArrayList<BrakeHandleWide>();

    public BrakeHandleWide(String wide) {
        this.wide = wide;
    }
}