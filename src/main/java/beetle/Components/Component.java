package beetle.Components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by VitaliiZhuk on 07.07.2017.
 */
@Entity
@Table(name="Components")
@NoArgsConstructor
@Getter
@Setter
public class Component {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Component( String name) {

        this.name = name;

    }

}