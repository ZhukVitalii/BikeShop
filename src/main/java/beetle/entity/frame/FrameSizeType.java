package beetle.entity.frame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by VitaliiZhuk on 06.07.2017.
 */
@Entity
@Table(name="frame_size_type")
@NoArgsConstructor
@Getter
@Setter
public class
FrameSizeType {
    @Id
    @GeneratedValue
    private long id;
    private String size;
    @ManyToMany(mappedBy = "frameSizeTypes")
    private Set<Frame> frames = new HashSet<>();

    public FrameSizeType(String size) {
        this.size = size;
    }
}
