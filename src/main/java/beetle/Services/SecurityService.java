package beetle.Services;

import beetle.Repositories.Security.CustomUserRepository;
import beetle.Entities.Security.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by VitaliiZhuk on 10.10.2017.
 */
@Service
public class SecurityService {
    @Autowired
    private CustomUserRepository customUserRepository;

    @Transactional(readOnly=true)
    public List<CustomUser> getAllUsers() {
        return customUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CustomUser getUserByLogin(String login) {
        return customUserRepository.findByLogin(login);
    }

    @Transactional(readOnly=true)
    public CustomUser getUserById(Long id) {
        return customUserRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsByLogin(String login) {
        return customUserRepository.existsByLogin(login);
    }

    @Transactional(readOnly = true)
    public boolean loginExistsForOtherId(String login, Long id) {
        return customUserRepository.loginExistsForOtherId(login, id);
    }

    @Transactional
    public void addUser(CustomUser customUser) {
        customUserRepository.save(customUser);
    }

    @Transactional
    public void updateUser(CustomUser customUser) {customUserRepository.save(customUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        customUserRepository.delete(id);
    }
}
