package beetle.Transmissions;

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
@Table(name="FrontSprocketNumbers")
@NoArgsConstructor
@Getter
@Setter
public class FrontSprocketNumber{
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="frontSprocketNumber", cascade=CascadeType.ALL)
    private List<Crank> cranks = new ArrayList<Crank>();

    @OneToMany(mappedBy="frontSprocketNumber", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs = new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="frontSprocketNumber", cascade= CascadeType.ALL)
    private List<FrontSprocketNumber> frontSprocketNumber = new ArrayList<FrontSprocketNumber>();

    public FrontSprocketNumber(String number) {
        this.number = number;
    }
}
