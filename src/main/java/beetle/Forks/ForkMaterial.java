package beetle.Forks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="ForkMaterials")
@NoArgsConstructor
@Getter
@Setter
public class ForkMaterial {
    @Id
    @GeneratedValue
    private long id;
    private String material;

    @OneToMany(mappedBy="forkMaterial", cascade=CascadeType.ALL)
    private List<Fork> forks = new ArrayList<Fork>();

    @OneToMany(mappedBy="forkMaterial", cascade= CascadeType.ALL)
    private List<ForkMaterial> forkMaterial = new ArrayList<ForkMaterial>();


    public ForkMaterial(String material) {
        this.material = material;
    }
}