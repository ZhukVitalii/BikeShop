package beetle.Brakes;

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
@Table(name="BrakeLiquids")
@NoArgsConstructor
@Getter
@Setter
public class BrakeLiquid {
    @Id
    @GeneratedValue
    private long id;
    private String liq;

    @OneToMany(mappedBy="brakeLiquid", cascade=CascadeType.ALL)
    private List<BrakeDiscHydraulic> brakeDiscHydraulics  = new ArrayList<BrakeDiscHydraulic>();


    @OneToMany(mappedBy="brakeLiquid", cascade= CascadeType.ALL)
    private List<BrakeLiquid> brakeLiquid = new ArrayList<BrakeLiquid>();


    public BrakeLiquid(String liq) {
        this.liq = liq;
    }
}
