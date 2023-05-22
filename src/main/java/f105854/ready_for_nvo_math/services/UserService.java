package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.User;
import f105854.ready_for_nvo_math.model.UserPrincipal;
import f105854.ready_for_nvo_math.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public void addUser(@ModelAttribute User user){
        userRepository.save(user);
    }

    public User findUserById(@PathVariable("id") int id){
        User user = userRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid user ID: " + id));
        return user;
    }

    public void updateUser(@ModelAttribute User user) throws Exception{
        User userInDB = userRepository.findById(user.getId()).orElse(null);
        if(userInDB != null){
            userInDB.setUsername(user.getUsername());
            userInDB.setEmail(user.getEmail());
            userInDB.setActive(user.isActive());
            userInDB.setRole(user.getRole());
            userInDB.setFirstName(user.getFirstName());
            userInDB.setLastName(user.getLastName());
            userInDB.setPassword(user.getPassword());
            userRepository.save(userInDB);
        } else {
            throw new Exception("User not found!");
        }
    }

    public void deleteUser(@PathVariable("id") int id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        userRepository.delete(user);
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        User currentUser = userRepository.findByUsername(userDetails.getUsername());

        return currentUser;
    }
}