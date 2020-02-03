package beetle.entity.wheels;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="spokes")
@NoArgsConstructor
@Getter
@Setter
public class Spoke extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    private String length;
    private String diameter;
}
