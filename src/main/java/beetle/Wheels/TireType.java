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
@Table(name="TireTypes")
@NoArgsConstructor
@Getter
@Setter
public class TireType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="tireType", cascade=CascadeType.ALL)
    private List<Tire> tires = new ArrayList<Tire>();

    @OneToMany(mappedBy="tireType", cascade= CascadeType.ALL)
    private List<TireType> tireType = new ArrayList<TireType>();

    public TireType(String type) {
        this.type = type;
    }
}