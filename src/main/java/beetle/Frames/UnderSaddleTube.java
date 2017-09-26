package beetle.Frames;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 06.07.2017.
 */
@Entity
@Table(name="UnderSaddleTubes")
@NoArgsConstructor
@Getter
@Setter
public class UnderSaddleTube {
    @Id
    @GeneratedValue
    private long id;
    private String diam;

    @OneToMany(mappedBy="underSaddleTube", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany(mappedBy="underSaddleTube", cascade= CascadeType.ALL)
    private List<UnderSaddleTube> underSaddleTube = new ArrayList<UnderSaddleTube>();

    public UnderSaddleTube(String diam) {
        this.diam = diam;
    }
}
