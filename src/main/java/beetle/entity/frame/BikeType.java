package beetle.entity.frame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Entity
@Table(name="bike_types")
@NoArgsConstructor
@Getter
@Setter
public class BikeType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

    public BikeType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BikeType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}