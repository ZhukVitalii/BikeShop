package beetle.Entities.Handlebars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Entities.Brakes.BrakeHandle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="HandlebarDiameters")
@NoArgsConstructor
@Getter
@Setter
public class HandlebarDiameter {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="handlebarDiameter", cascade=CascadeType.ALL)
    private List<Handlebar> handlebars = new ArrayList<Handlebar>();

    @OneToMany(mappedBy="handlebarDiameter", cascade=CascadeType.ALL)
    private List<BrakeHandle> brakeHandles = new ArrayList<BrakeHandle>();

    @OneToMany(mappedBy="handlebarDiameter", cascade= CascadeType.ALL)
    private List<HandlebarDiameter> handlebarDiameter = new ArrayList<HandlebarDiameter>();

    public HandlebarDiameter(String diam) {
        this.diam = diam;
    }
}
