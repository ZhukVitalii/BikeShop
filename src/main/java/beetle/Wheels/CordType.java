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
@Table(name="CordTypes")
@NoArgsConstructor
@Getter
@Setter
public class CordType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="cordType", cascade=CascadeType.ALL)
    private List<Tire> tires = new ArrayList<Tire>();

    @OneToMany(mappedBy="cordType", cascade= CascadeType.ALL)
    private List<CordType> cordType = new ArrayList<CordType>();

    public CordType(String type) {
        this.type = type;
    }
}