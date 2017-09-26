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
@Table(name="TractionTypes")
@NoArgsConstructor
@Getter
@Setter
public class TractionType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="tractionType", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs  = new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="tractionType", cascade= CascadeType.ALL)
    private List<TractionType> tractionType = new ArrayList<TractionType>();

    public TractionType (String type) {
        this.type = type;
    }
}
