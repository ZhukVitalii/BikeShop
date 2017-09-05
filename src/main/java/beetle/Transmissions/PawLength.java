package beetle.Transmissions;

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
@Table(name="PawLengths")
@NoArgsConstructor
@Getter
@Setter
public class PawLength {
    @Id
    @GeneratedValue
    private long id;
    private String length;

    @OneToMany(mappedBy="pawLength", cascade=CascadeType.ALL)
    private List<BackDerailleur> backDerailleurs  = new ArrayList<BackDerailleur>();



    @OneToMany(mappedBy="pawLength", cascade= CascadeType.ALL)
    private List<PawLength> pawLength = new ArrayList<PawLength>();


    public PawLength(String length) {
        this.length = length;
    }
}