package beetle.entity.wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="back_sprocket_types")
@NoArgsConstructor
@Getter
@Setter
public class BackSprocketType {
    @Id
    @GeneratedValue
    private long id;
    private String type;


    @OneToMany(mappedBy="backSprocketType", cascade=CascadeType.ALL)
    private List<BackHub> backHubs = new ArrayList<BackHub>();

    @OneToMany(mappedBy="backSprocketType", cascade= CascadeType.ALL)
    private List<BackSprocketType> backSprocketType = new ArrayList<BackSprocketType>();

    public BackSprocketType(String type) {
        this.type = type;
    }
}