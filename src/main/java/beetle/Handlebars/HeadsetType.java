package beetle.Handlebars;

import beetle.Frames.Frame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */
@Entity
@Table(name="HeadsetTypes")
@NoArgsConstructor
@Getter
@Setter
public class HeadsetType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    @OneToMany(mappedBy="headsetType", cascade=CascadeType.ALL)
    private List<Headset> headsets = new ArrayList<Headset>();

    @OneToMany(mappedBy="headsetType", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany(mappedBy="headsetType", cascade= CascadeType.ALL)
    private List<HeadsetType> headsetType = new ArrayList<HeadsetType>();


    public HeadsetType(String type) {
        this.type = type;
    }
}

