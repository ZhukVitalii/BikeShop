package beetle.entity.wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
@Entity
@Table(name="spoke_numbers")
@NoArgsConstructor
@Getter
@Setter
public class SpokeNumber {
    @Id
    @GeneratedValue
    private long id;
    private String number;
//
//    @OneToMany(mappedBy="spokeNumber", cascade=CascadeType.ALL)
//    private List<Wheel> wheels = new ArrayList<Wheel>();
//
//    @OneToMany(mappedBy="spokeNumber", cascade=CascadeType.ALL)
//    private List<Rim> rims = new ArrayList<Rim>();
//
//    @OneToMany(mappedBy="spokeNumber", cascade=CascadeType.ALL)
//    private List<FrontHub> frontHubs = new ArrayList<FrontHub>();
//
//    @OneToMany(mappedBy="spokeNumber", cascade=CascadeType.ALL)
//    private List<BackHub> backHubs = new ArrayList<BackHub>();
//
//    @OneToMany(mappedBy="spokeNumber", cascade= CascadeType.ALL)
//    private List<SpokeNumber> spokeNumber = new ArrayList<SpokeNumber>();


    public SpokeNumber (String number) {
        this.number = number;
    }
}