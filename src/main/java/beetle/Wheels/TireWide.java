package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 25.06.2017.
 */
@Entity
@Table(name="TireWides")
@NoArgsConstructor
@Getter
@Setter
public class TireWide {
    @Id
    @GeneratedValue
    private long id;
    private String wide;

    @OneToMany(mappedBy="tireWide", cascade=CascadeType.ALL)
    private List<Tire> tires = new ArrayList<Tire>();


    @OneToMany(mappedBy="tireWide", cascade= CascadeType.ALL)
    private List<TireWide> tireWide = new ArrayList<TireWide>();


    public TireWide(String wide) {
        this.wide = wide;
    }
}