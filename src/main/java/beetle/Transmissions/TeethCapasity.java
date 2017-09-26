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
@Table(name="TeethCapasitys")
@NoArgsConstructor
@Getter
@Setter
public class TeethCapasity {
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="teethCapasity", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs  = new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="teethCapasity", cascade= CascadeType.ALL)
    private List<TeethCapasity> teethCapasity = new ArrayList<TeethCapasity>();

    public TeethCapasity(String number) {
        this.number = number;
    }
}