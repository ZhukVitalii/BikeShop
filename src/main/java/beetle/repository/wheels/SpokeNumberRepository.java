package beetle.repository.wheels;

import beetle.entity.wheels.SpokeNumber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
public interface SpokeNumberRepository extends JpaRepository<SpokeNumber, Long> {
}
