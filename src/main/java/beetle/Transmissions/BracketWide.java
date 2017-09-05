package beetle.Transmissions;

import beetle.Frames.Frame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.07.2017.
 */
@Entity
@Table(name="BracketDiams")
@NoArgsConstructor
@Getter
@Setter
public class BracketWide {
    @Id
    @GeneratedValue
    private long id;
    private String wide;

    @OneToMany(mappedBy="bracketWide", cascade=CascadeType.ALL)
    private List<Bracket> brackets = new ArrayList<Bracket>();
    @OneToMany(mappedBy="bracketWide", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

    @OneToMany (mappedBy="bracketWide", cascade= CascadeType.ALL)
    private List<BracketWide> bracketWide = new ArrayList<BracketWide>();


    public BracketWide(String wide) {
        this.wide = wide;
    }
}