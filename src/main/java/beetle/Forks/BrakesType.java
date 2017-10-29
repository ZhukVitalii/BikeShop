package beetle.Forks;

import beetle.Frames.Frame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Wheels.BackHub;
import beetle.Wheels.FrontHub;
import beetle.Wheels.Rim;
import beetle.Wheels.Wheel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 31.05.2017.
 */
@Entity
@Table(name="BrakesTypes")
@NoArgsConstructor
@Getter
@Setter
public class BrakesType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="brakesType", cascade=CascadeType.ALL)
    private List<Fork> forks = new ArrayList<Fork>();

    @OneToMany(mappedBy="brakesType", cascade=CascadeType.ALL)
    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();

    @OneToMany(mappedBy="brakesType", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="brakesType", cascade=CascadeType.ALL)
    private List<Wheel> wheels = new ArrayList<Wheel>();

    @OneToMany(mappedBy="brakesType", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="brakesType", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany (mappedBy="brakesType", cascade= CascadeType.ALL)
    private List<BrakesType> brakesType = new ArrayList<BrakesType>();

    public BrakesType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }
    public String getType(){
        return type;
    }
}
