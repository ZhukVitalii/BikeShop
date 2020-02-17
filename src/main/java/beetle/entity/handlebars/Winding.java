package beetle.entity.handlebars;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 04.06.2017.
 */
@Entity
@Table(name="windings")
@NoArgsConstructor
@Getter
@Setter
public class Winding extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    private String length;
    private String wide;
}
