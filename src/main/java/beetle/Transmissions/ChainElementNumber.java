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
@Table(name="ChainElementNumbers")
@NoArgsConstructor
@Getter
@Setter
public class ChainElementNumber{
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @OneToMany(mappedBy="chainElementNumber", cascade=CascadeType.ALL)
    private List<ChainElementNumber> chainElementNumbers = new ArrayList<ChainElementNumber>();



    @OneToMany(mappedBy="chainElementNumber", cascade= CascadeType.ALL)
    private List<ChainElementNumber> chainElementNumber = new ArrayList<ChainElementNumber>();


    public ChainElementNumber(String number) {
        this.number = number ;
    }
}

