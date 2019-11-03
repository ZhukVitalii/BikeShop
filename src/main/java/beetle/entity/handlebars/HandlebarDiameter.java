package beetle.entity.handlebars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.brake.BrakeHandle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="handlebar_diameters")
@NoArgsConstructor
@Getter
@Setter
public class HandlebarDiameter {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiam() {
        return diam;
    }

    public void setDiam(String diam) {
        this.diam = diam;
    }
}
