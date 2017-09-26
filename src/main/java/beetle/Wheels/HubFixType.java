package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 18.06.2017.
 */
@Entity
@Table(name="HumFixTypes")
@NoArgsConstructor
@Getter
@Setter
public class HubFixType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="hubFixType", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="hubFixType", cascade=CascadeType.ALL)
    private List<BackHub>  backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="hubFixType", cascade= CascadeType.ALL)
    private List<HubFixType> hubFixType = new ArrayList<HubFixType>();

    public HubFixType(String type) {
        this.type = type;
    }
}