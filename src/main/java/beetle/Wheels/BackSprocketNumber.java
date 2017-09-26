package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="BackSprocketNumbers")
@NoArgsConstructor
@Getter
@Setter
public class BackSprocketNumber {
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="backSprocketNumber", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="backSprocketNumber", cascade= CascadeType.ALL)
    private List<BackSprocketNumber> backSprocketNumber = new ArrayList<BackSprocketNumber>();

    public BackSprocketNumber(String number) {
        this.number = number;
    }
}
