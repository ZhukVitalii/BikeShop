package beetle.Entities.Transmission;

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
@Table(name="TransmissionMakers")
@NoArgsConstructor
@Getter
@Setter
public class TransmissionMaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Crank> cranks = new ArrayList<Crank>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Bracket> brackets = new ArrayList<Bracket>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<BackGearTr> backGearTrs = new ArrayList<BackGearTr>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<BackGearKas> backGearKass = new ArrayList<BackGearKas>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Chain> chains = new ArrayList<Chain>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs= new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<BackDerailleur> backDerailleurs = new ArrayList<BackDerailleur>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Pedal> pedals = new ArrayList<Pedal>();

    @OneToMany(mappedBy="maker", cascade= CascadeType.ALL)
    private List<TransmissionMaker> maker = new ArrayList<TransmissionMaker>();

    public TransmissionMaker(String name) {
        this.name = name;
    }
}
