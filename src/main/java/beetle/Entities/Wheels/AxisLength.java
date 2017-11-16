package beetle.Entities.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="AxisLengths")
@NoArgsConstructor
@Getter
@Setter
public class AxisLength {
    @Id
    @GeneratedValue
    private long id;
    private String length;

    @OneToMany(mappedBy="axisLength", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="axisLength", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="axisLength", cascade= CascadeType.ALL)
    private List<AxisLength> axisLength = new ArrayList<AxisLength>();

    public AxisLength(String length) {
        this.length = length;
    }
}