package beetle.Bakes;

import beetle.Forks.Fork;
import beetle.Frames.Frame;
import beetle.Handlebars.Handlebar;
import beetle.Transmissions.Crank;
import beetle.Wheels.Rim;
import beetle.Wheels.Wheel;
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
@Table(name="BikeTypes")
@NoArgsConstructor
@Getter
@Setter
public class BikeType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="bikeType", cascade=CascadeType.ALL)
    private List<Crank> cranks = new ArrayList<Crank>();


    @OneToMany(mappedBy="bikeType", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany(mappedBy="bikeType", cascade=CascadeType.ALL)
    private List<Fork> forks = new ArrayList<Fork>();

    @OneToMany(mappedBy="bikeType", cascade=CascadeType.ALL)
    private List<Wheel> wheels = new ArrayList<Wheel>();

    @OneToMany(mappedBy="bikeType", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="bikeType", cascade=CascadeType.ALL)
    private List<Handlebar> handlebars = new ArrayList<Handlebar>();

    @OneToMany(mappedBy="bikeType", cascade= CascadeType.ALL)
    private List<BikeType> bikeType = new ArrayList<BikeType>();


    public BikeType(String type) {
        this.type = type;
    }
}