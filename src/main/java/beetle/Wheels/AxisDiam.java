package beetle.Wheels;

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
@Table(name="AxisDiams")
@NoArgsConstructor
@Getter
@Setter
public class AxisDiam {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="axisDiam", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="axisDiam", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="axisDiam", cascade= CascadeType.ALL)
    private List<AxisDiam> axisDiam = new ArrayList<AxisDiam>();


    public AxisDiam(String diam) {
        this.diam = diam;
    }
}