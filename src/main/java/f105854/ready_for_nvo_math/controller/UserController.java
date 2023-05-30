package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.User;
import f105854.ready_for_nvo_math.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public String showUsersPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(path = "/users/add")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "users-add";
    }

    @PostMapping(path = "/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String showUpdateForm(Model model) {
        User user = userService.findUserById(userService.getCurrentUser().getId());
        model.addAttribute("user", user);
        return "users-edit";
    }

    @PostMapping("/users/edit/{id}")
    public String updateUser(@ModelAttribute User user) throws Exception {
        userService.updateUser(user);
        return "redirect:/";
    }


    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
