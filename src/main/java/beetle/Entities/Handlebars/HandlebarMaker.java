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

    @OneToMany(mappedBy="handlebarMaker", cascade=CascadeType.ALL)
    private List<Handlebar> handlebars = new ArrayList<Handlebar>();

    @OneToMany(mappedBy="handlebarMaker", cascade= CascadeType.ALL)
    private List<HandlebarMaker> handlebarMaker = new ArrayList<HandlebarMaker>();

    public HandlebarMaker(String name) {
        this.name = name;
    }
}
