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
@Table(name="back_sprocket_sizes")
@NoArgsConstructor
@Getter
@Setter
public class BackSprocketSize {
    @Id
    @GeneratedValue
    private long id;
    private String size;

    @OneToMany(mappedBy="backSprocketSize", cascade=CascadeType.ALL)
    private List<BackGearTr> backGearTrs = new ArrayList<BackGearTr>();

    @OneToMany(mappedBy="backSprocketSize", cascade=CascadeType.ALL)
    private List<BackGearKas> backGearKass = new ArrayList<BackGearKas>();

    @OneToMany(mappedBy="backSprocketSize", cascade= CascadeType.ALL)
    private List<BackSprocketSize> backSprocketSize = new ArrayList<BackSprocketSize>();

    public BackSprocketSize(String size) {
        this.size = size;
    }
}
