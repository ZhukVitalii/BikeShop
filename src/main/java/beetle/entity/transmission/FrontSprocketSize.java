package beetle.entity.transmission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
@Entity
@Table(name="front_sprocket_sizes")
@NoArgsConstructor
@Getter
@Setter
public class FrontSprocketSize {
    @Id
    @GeneratedValue
    private long id;
    private String size;

    @OneToMany(mappedBy="frontSprocketSize", cascade=CascadeType.ALL)
    private List<Crank> cranks = new ArrayList<Crank>();

    @OneToMany(mappedBy="frontSprocketSize", cascade= CascadeType.ALL)
    private List<FrontSprocketSize> frontSprocketSize = new ArrayList<FrontSprocketSize>();

    public FrontSprocketSize(String size) {
        this.size = size;
    }
}