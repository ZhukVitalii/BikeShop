package beetle.entity.transmission;

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
@Table(name="front_sprocket_maxs")
@NoArgsConstructor
@Getter
@Setter
public class FrontSprocketMax{
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="frontSprocketMax", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs  = new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="frontSprocketMax", cascade=CascadeType.ALL)
    private List<Crank> cranks  = new ArrayList<Crank>();

    @OneToMany(mappedBy="frontSprocketMax", cascade= CascadeType.ALL)
    private List<FrontSprocketMax> frontSprocketMax = new ArrayList<FrontSprocketMax>();

    public FrontSprocketMax(String number) {
        this.number = number;
    }
}