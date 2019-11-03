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
@Table(name="back_sprocket_mins")
@NoArgsConstructor
@Getter
@Setter
public class BackSprocketMin {
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="backSprocketMin", cascade=CascadeType.ALL)
    private List<BackDerailleur> backDerailleurs  = new ArrayList<BackDerailleur>();

    @OneToMany(mappedBy="backSprocketMin", cascade=CascadeType.ALL)
    private List<BackGearTr> backGearTrs  = new ArrayList<BackGearTr>();

    @OneToMany(mappedBy="backSprocketMin", cascade=CascadeType.ALL)
    private List<BackGearKas> backGearKass  = new ArrayList<BackGearKas>();

    @OneToMany(mappedBy="backSprocketMin", cascade= CascadeType.ALL)
    private List<BackSprocketMin> backSprocketMin = new ArrayList<BackSprocketMin>();

    public BackSprocketMin(String number) {
        this.number = number;
    }
}