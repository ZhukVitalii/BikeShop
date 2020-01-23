package beetle.repository.brake;

import beetle.entity.brake.Brake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakeRepository  extends JpaRepository<Brake, Long> {
}
