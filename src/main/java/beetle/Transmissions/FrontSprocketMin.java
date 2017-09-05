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
@Table(name="FrontSprocketMins")
@NoArgsConstructor
@Getter
@Setter
public class FrontSprocketMin{
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="frontSprocketMin", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs  = new ArrayList<FrontDerailleur>();
    @OneToMany(mappedBy="frontSprocketMin", cascade=CascadeType.ALL)
    private List<Crank> cranks  = new ArrayList<Crank>();



    @OneToMany(mappedBy="frontSprocketMin", cascade= CascadeType.ALL)
    private List<FrontSprocketMin> frontSprocketMin = new ArrayList<FrontSprocketMin>();


    public FrontSprocketMin(String number) {
        this.number = number;
    }
}