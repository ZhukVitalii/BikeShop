package beetle.entity.wheels;

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
@Table(name="etrto_sizes")
@NoArgsConstructor
@Getter
@Setter
public class EtrtoSize {
    @Id
    @GeneratedValue
    private long id;
    private String size;

    @OneToMany(mappedBy="etrtoSize", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="etrtoSize", cascade= CascadeType.ALL)
    private List<EtrtoSize> etrtoSize = new ArrayList<EtrtoSize>();

    public EtrtoSize(String size) {
        this.size = size;
    }
}