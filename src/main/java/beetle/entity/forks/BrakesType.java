package beetle.entity.forks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 31.05.2017.
 */
@Entity
@Table(name="brakes_types")
@NoArgsConstructor
@Getter
@Setter
public class BrakesType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    public BrakesType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }
    public String getType(){
        return type;
    }
}
