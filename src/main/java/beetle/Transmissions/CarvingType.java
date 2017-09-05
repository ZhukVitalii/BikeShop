package beetle.Transmissions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.07.2017.
 */
@Entity
@Table(name="CarvingTypes")
@NoArgsConstructor
@Getter
@Setter
public class CarvingType{
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="carvingType", cascade=CascadeType.ALL)
    private List<Bracket> brackets  = new ArrayList<Bracket>();



    @OneToMany(mappedBy="carvingType", cascade= CascadeType.ALL)
    private List<CarvingType> carvingType = new ArrayList<CarvingType>();


    public CarvingType(String type) {
        this.type = type;
    }
}