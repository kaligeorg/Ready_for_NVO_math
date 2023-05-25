package f105854.ready_for_nvo_math.services;

import constant.RoleType;
import f105854.ready_for_nvo_math.model.RegistrationRequest;
import f105854.ready_for_nvo_math.model.Student;
import f105854.ready_for_nvo_math.model.Teacher;
import f105854.ready_for_nvo_math.model.User;
import f105854.ready_for_nvo_math.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserRepository userRepository;
    private EmailValidator emailValidator;
    private UserService userService;
    private UserPrincipalDetailService userPrincipalDetailService;

    public void register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        User user = new User(
                0,
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getUsername(),
                registrationRequest.getPassword(),
                true,
                registrationRequest.getRoleType(),
                null,
                null
        );

        if (registrationRequest.getRoleType() == RoleType.STUDENT){
            Student student =  new Student(0, user);
            userPrincipalDetailService.signUpUser(user, student, null);
        } else if (registrationRequest.getRoleType() == RoleType.TEACHER){
            Teacher teacher =  new Teacher(0, user);
            userPrincipalDetailService.signUpUser(user, null, teacher);
        }
    }
}
