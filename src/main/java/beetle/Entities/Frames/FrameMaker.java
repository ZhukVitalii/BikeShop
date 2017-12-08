package beetle.Entities.Frames;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="FrameMakers")
@NoArgsConstructor
@Getter
@Setter
public class FrameMaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;

   @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Frame> frames = new ArrayList<Frame>();

   @OneToMany(mappedBy="maker", cascade= CascadeType.ALL)
    private List<FrameMaker> maker = new ArrayList<FrameMaker>();


  public FrameMaker(String name) {
        this.name = name;
    }
}
