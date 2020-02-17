package beetle.entity.handlebars;

import beetle.entity.BaseEntity;
import beetle.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */
@Entity
@Table(name="grips")
@NoArgsConstructor
@Getter
@Setter
public class Grips extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    private String length;
}
