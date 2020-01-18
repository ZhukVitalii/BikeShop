package beetle.repository.transmission;

import beetle.entity.transmission.BracketWide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by VitaliiZhuk on 03.07.2017.
 */
@Repository
public interface BracketWideRepository extends JpaRepository<BracketWide, Long> {
}
