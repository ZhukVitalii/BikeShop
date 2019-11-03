package beetle.repository.brake;

import beetle.entity.brake.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
}
