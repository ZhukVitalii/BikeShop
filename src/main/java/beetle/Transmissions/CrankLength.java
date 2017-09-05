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
@Table(name="CrankLengths")
@NoArgsConstructor
@Getter
@Setter
public class CrankLength{
    @Id
    @GeneratedValue
    private long id;
    private String length;

    @OneToMany(mappedBy="crankLength", cascade=CascadeType.ALL)
    private List<Crank> cranks = new ArrayList<Crank>();



    @OneToMany(mappedBy="crankLength", cascade= CascadeType.ALL)
    private List<CrankLength> crankLength = new ArrayList<CrankLength>();


    public CrankLength(String length) {
        this.length = length;
    }
}
