package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Role;
import f105854.ready_for_nvo_math.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/roles")
    public String showRolesPage(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping(path = "/roles/add")
    public String showAddRolePage(Model model) {
        model.addAttribute("role", new Role());
        return "roles-add";
    }

    @PostMapping(path = "/roles/add")
    public String addRole(@ModelAttribute Role role) {
        roleService.addRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/roles/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        return "roles-edit";
    }

    @PostMapping("/roles/edit/{id}")
    public String updateRole(@ModelAttribute Role role) throws Exception {
        roleService.updateRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/roles/delete/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }
}
