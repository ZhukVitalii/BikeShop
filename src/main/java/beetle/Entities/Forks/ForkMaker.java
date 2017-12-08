package beetle.Entities.Forks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */
@Entity
@Table(name="ForkMakers")
@NoArgsConstructor
@Getter
@Setter
public class ForkMaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="maker", cascade=CascadeType.ALL)
    private List<Fork> forks = new ArrayList<Fork>();

    @OneToMany(mappedBy="maker", cascade= CascadeType.ALL)
    private List<ForkMaker> maker = new ArrayList<ForkMaker>();

    public ForkMaker(String name) {
        this.name = name;
    }
}

