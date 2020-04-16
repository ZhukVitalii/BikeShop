package beetle.security;

import beetle.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by VitaliiZhuk on 10.10.2017.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleEnum> {
}
