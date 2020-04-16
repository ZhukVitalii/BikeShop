package beetle.security;

import beetle.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by VitaliiZhuk on 10.10.2017.
 */
@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional(readOnly=true)
    public UserRole getUserRole(UserRoleEnum userRoleEnum) {
        return userRoleRepository.findOne(userRoleEnum);
    }

    @Transactional
    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
