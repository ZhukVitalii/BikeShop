package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 15.06.2017.
 */
@Entity
@Table(name="Nipples")
@NoArgsConstructor
@Getter
@Setter
public class Nipple {
    @Id
    @GeneratedValue
    private long id;
    private String nipple;

    @OneToMany(mappedBy="nipple", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="nipple", cascade= CascadeType.ALL)
    private List<Nipple> nipples = new ArrayList<Nipple>();


    public Nipple(String nipple) {
        this.nipple = nipple;
    }
}