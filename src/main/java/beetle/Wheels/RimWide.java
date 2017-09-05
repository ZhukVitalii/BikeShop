package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="RimWides")
@NoArgsConstructor
@Getter
@Setter
public class RimWide {
    @Id
    @GeneratedValue
    private long id;
    private String wide;

    @OneToMany(mappedBy="rimWide", cascade=CascadeType.ALL)
    private List<Wheel> wheels = new ArrayList<Wheel>();
    @OneToMany(mappedBy="rimWide", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="rimWide", cascade= CascadeType.ALL)
    private List<RimWide> rimWide = new ArrayList<RimWide>();


    public RimWide(String wide) {
        this.wide = wide;
    }
}