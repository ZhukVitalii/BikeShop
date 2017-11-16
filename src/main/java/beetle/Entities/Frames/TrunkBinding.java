package beetle.Entities.Frames;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 06.07.2017.
 */
@Entity
@Table(name="TrunkBindings")
@NoArgsConstructor
@Getter
@Setter
public class TrunkBinding {
    @Id
    @GeneratedValue
    private long id;
    private String trunk;

    @OneToMany(mappedBy="trunkBinding", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany(mappedBy="trunkBinding", cascade= CascadeType.ALL)
    private List<TrunkBinding> trunkBinding = new ArrayList<TrunkBinding>();

    public TrunkBinding(String trunk) {
        this.trunk = trunk;
    }
}