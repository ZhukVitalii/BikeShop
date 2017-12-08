package beetle.Entities.Handlebars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Entity
@Table(name="HandlebarMakers")
@NoArgsConstructor
@Getter
@Setter
public class HandlebarMaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Grips> grips = new ArrayList<Grips>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Handlebar> handlebars = new ArrayList<Handlebar>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Stem> stems = new ArrayList<>();

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Headset> headsets = new ArrayList<>();

    @OneToMany(mappedBy="maker", cascade= CascadeType.ALL)
    private List<Winding> windings = new ArrayList<>();

    public HandlebarMaker(String name) {
        this.name = name;
    }
}
