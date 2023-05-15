package f105854.ready_for_nvo_math.model;

import constant.RoleType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    private RoleType roleType;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String firstName, String lastName, String username, String password, String email, RoleType roleType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleType = roleType;
    }
}
