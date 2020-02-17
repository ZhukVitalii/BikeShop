package beetle.entity.handlebars;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.entity.forks.TubeDiameter;

import javax.persistence.*;

@Entity
@Table(name="headsets")
@NoArgsConstructor
@Getter
@Setter
public class Headset extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="type_id")
    private HeadsetType headsetType;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private TubeDiameter tubeDiameter;
    private String size;
}
