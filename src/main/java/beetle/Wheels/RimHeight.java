package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 15.06.2017.
 */
@Entity
@Table(name="RimHeights")
@NoArgsConstructor
@Getter
@Setter
public class RimHeight {
    @Id
    @GeneratedValue
    private long id;
    private String height;

    @OneToMany(mappedBy="rimHeight", cascade=CascadeType.ALL)
    private List<Rim> rims = new ArrayList<Rim>();

    @OneToMany(mappedBy="rimHeight", cascade= CascadeType.ALL)
    private List<RimHeight> rimHeight = new ArrayList<RimHeight>();

    public RimHeight(String height) {
        this.height = height;
    }
}