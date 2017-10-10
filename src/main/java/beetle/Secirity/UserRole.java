package beetle.Secirity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by VitaliiZhuk on 10.10.2017.
 */
@Entity
@Table(name="UserRoles")
@NoArgsConstructor
@Getter
@Setter
public class UserRole {
    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRoleEnum;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<CustomUser> customUserList = new ArrayList<>();


        public UserRole(UserRoleEnum userRoleEnum) {
            this.id=userRoleEnum.ordinal();
            this.userRoleEnum = userRoleEnum;
        }

        public UserRoleEnum getUserRoleEnum() {
            return userRoleEnum;
        }

    public String getString() {
        return "ROLE_" + this.userRoleEnum.name();
    }

}
