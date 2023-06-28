package f105854.ready_for_nvo_math.services;

import constant.RoleType;
import f105854.ready_for_nvo_math.model.User;
import f105854.ready_for_nvo_math.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void addUser() {
        User userAdd = new User(0, "Violeta", "Encheva", "v_encheva@gmail.com", "v_encheva", "password", true,
                RoleType.TEACHER, null, null, null);
        userService.addUser(userAdd);
        Assertions.assertEquals(userService.findAll().size(), 8);
    }

    @Test
    void updateUser() throws Exception{
        User userUpdate = new User(1, "Violeta", "Encheva", "v_encheva@gmail.com", "v_encheva", "password", true,
                RoleType.ADMIN, null, null, null);
        userService.updateUser(userUpdate);
        Assertions.assertEquals("Encheva", userService.findUserById(userUpdate.getId()).getLastName());
    }

    @Test
    public void deleteUser() throws Exception{
        User user = userRepository.save(new User(0, "Ivan", "Tishkov", "i_tishkov@gmail.com",
                "i_tishkov", "password", true, RoleType.TEACHER, null, null,
                null));
        userService.deleteUser(user.getId());
        Assertions.assertFalse(userService.findAll().contains(user));
    }
}