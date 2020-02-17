package beetle.entity.handlebars;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="handlebars")
@NoArgsConstructor
@Getter
@Setter
public class Handlebar extends BaseEntity  {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="type_id")
    private BikeType bikeType;
    private String handlebarWide;
    private Double handlebarDiameter;
    private String handlebarHeight;

}
