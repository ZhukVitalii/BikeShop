package beetle.Transmissions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="CollarDiams")
@NoArgsConstructor
@Getter
@Setter
public class CollarDiam{
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="collarDiam", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs = new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="collarDiam", cascade= CascadeType.ALL)
    private List<CollarDiam> collarDiam = new ArrayList<CollarDiam>();

    public CollarDiam(String diam) {
        this.diam = diam;
    }
}

