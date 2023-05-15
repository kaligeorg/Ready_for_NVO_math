package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.RegistrationRequest;
import f105854.ready_for_nvo_math.model.Student;
import f105854.ready_for_nvo_math.model.Teacher;
import f105854.ready_for_nvo_math.model.User;
import f105854.ready_for_nvo_math.repository.RoleRepository;
import f105854.ready_for_nvo_math.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
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
                this.roleRepository.findById(2).get(),
                null,
                null
        );
        Student student =  new Student(
                0,
                user
        );

        userPrincipalDetailService.signUpUser(user, student);
    }

    public void registerTeacher(RegistrationRequest registrationRequest) {
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
                this.roleRepository.findById(1).get(),
                null,
                null
        );
        Teacher teacher = new Teacher(
                0,
                user
        );

        userPrincipalDetailService.signUpTeacher(user, teacher);
    }
}
