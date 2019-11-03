package beetle.entity.transmission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Entity
@Table(name="bracket_types")
@NoArgsConstructor
@Getter
@Setter
public class BracketType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="bracketType", cascade=CascadeType.ALL)
    private List<Crank> cranks = new ArrayList<Crank>();

    @OneToMany(mappedBy="bracketType", cascade=CascadeType.ALL)
    private List<Bracket> brackets = new ArrayList<Bracket>();

    @OneToMany(mappedBy="bracketType", cascade= CascadeType.ALL)
    private List<BracketType> bracketType = new ArrayList<BracketType>();

    public BracketType(String type) {
        this.type = type;
    }
}
