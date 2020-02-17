package beetle.entity.forks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 30.05.2017.
 */
@Entity
@Table(name="tube_diameters")
@NoArgsConstructor
@Getter
@Setter
public class TubeDiameter {
    @Id
    @GeneratedValue
    private long id;
    private String diam;
}
