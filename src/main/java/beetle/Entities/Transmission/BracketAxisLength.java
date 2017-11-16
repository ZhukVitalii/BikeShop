package beetle.Entities.Transmission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.07.2017.
 */
@Entity
@Table(name="BracketAxisLengths")
@NoArgsConstructor
@Getter
@Setter
public class BracketAxisLength {
    @Id
    @GeneratedValue
    private long id;
    private String length;

    @OneToMany(mappedBy="bracketAxisLength", cascade=CascadeType.ALL)
    private List<Bracket> brackets = new ArrayList<Bracket>();

    @OneToMany(mappedBy="bracketAxisLength", cascade= CascadeType.ALL)
    private List<BracketAxisLength> bracketAxisLength = new ArrayList<BracketAxisLength>();

    public BracketAxisLength(String length) {
        this.length = length;
    }
}
