package beetle.entity.handlebars;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.forks.TubeDiameter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 07.06.2017.
 */
@Entity
@Table(name="stems")
@NoArgsConstructor
@Getter
@Setter
public class Stem extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    private String angle;
    @Column(name="handlebar_diam")
    private Double handlebarDiameter;
    @ManyToOne
    @JoinColumn(name="tube_diam_id")
    private TubeDiameter tubeDiameter;
    private String length;

}
