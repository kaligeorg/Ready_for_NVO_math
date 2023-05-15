package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.configuration.PasswordEncoder;
import f105854.ready_for_nvo_math.model.Student;
import f105854.ready_for_nvo_math.model.Teacher;
import f105854.ready_for_nvo_math.model.User;
import f105854.ready_for_nvo_math.model.UserPrincipal;
import f105854.ready_for_nvo_math.repository.StudentRepository;
import f105854.ready_for_nvo_math.repository.TeacherRepository;
import f105854.ready_for_nvo_math.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserPrincipalDetailService implements UserDetailsService {
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserPrincipalDetailService(UserRepository userRepository, TeacherRepository teacherRepository,
                                      StudentRepository studentRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = this.userRepository.findByUsername(email);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }

    public void signUpUser(User user, Student student){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalStateException("Email already taken!");
        }

        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        studentRepository.save(student);
    }

    public void signUpTeacher(User user, Teacher teacher){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalStateException("Email already taken!");
        }

        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        teacherRepository.save(teacher);
    }
}
