package beetle.Entities.Security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/**
 * Created by VitaliiZhuk on 10.10.2017.
 */
@Entity
@Table(name="CustomUsers")
@NoArgsConstructor
@Getter
@Setter
public class CustomUser {
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id")
    private UserRole role;
    private String email;
    private String phone;

    public CustomUser(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public CustomUser(String login, String password, UserRole role, String email, String phone) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


}
