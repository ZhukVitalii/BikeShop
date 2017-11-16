package beetle.Entities.Frames;

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
@Table(name="FrameSizes")
@NoArgsConstructor
@Getter
@Setter
public class FrameSize {
    @Id
    @GeneratedValue
    private long id;
    private String size;

    @OneToMany(mappedBy="frameSize", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany(mappedBy="frameSize", cascade= CascadeType.ALL)
    private List<FrameSize> frameSize = new ArrayList<FrameSize>();

    public FrameSize (String size) {
        this.size = size;
    }
}
