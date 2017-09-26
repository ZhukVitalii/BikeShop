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
@Table(name="BackSprocketMaxs")
@NoArgsConstructor
@Getter
@Setter
public class BackSprocketMax {
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="backSprocketMax", cascade=CascadeType.ALL)
    private List<BackDerailleur> backDerailleurs  = new ArrayList<BackDerailleur>();

    @OneToMany(mappedBy="backSprocketMax", cascade=CascadeType.ALL)
    private List<BackGearKas> backGearKass  = new ArrayList<BackGearKas>();

    @OneToMany(mappedBy="backSprocketMax", cascade=CascadeType.ALL)
    private List<BackGearTr> backGearTrs  = new ArrayList<BackGearTr>();

    @OneToMany(mappedBy="backSprocketMax", cascade= CascadeType.ALL)
    private List<BackSprocketMax> backSprocketMax = new ArrayList<BackSprocketMax>();

    public BackSprocketMax(String number) {
        this.number = number;
    }
}