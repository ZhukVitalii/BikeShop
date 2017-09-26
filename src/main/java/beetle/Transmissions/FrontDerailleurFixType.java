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
@Table(name="FrontDerailleurFixTypes")
@NoArgsConstructor
@Getter
@Setter
public class FrontDerailleurFixType{
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="frontDerailleurFixType", cascade=CascadeType.ALL)
    private List<FrontDerailleur> frontDerailleurs  = new ArrayList<FrontDerailleur>();

    @OneToMany(mappedBy="frontDerailleurFixType", cascade= CascadeType.ALL)
    private List<FrontDerailleurFixType> frontDerailleurFixType = new ArrayList<FrontDerailleurFixType>();

    public FrontDerailleurFixType(String type) {
        this.type = type;
    }
}