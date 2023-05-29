package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Admin;
import f105854.ready_for_nvo_math.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/admins")
    public String showAdminsPage(Model model) {
        List<Admin> admins = adminService.findAll(model);
        model.addAttribute("admins", admins);
        return "admins";
    }

    @GetMapping(path = "/admins/add")
    public String showAddAdminPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "admins-add";
    }

    @PostMapping(path = "/admins/add")
    public String addAdmin(@ModelAttribute Admin admin) {
        adminService.addAdmin(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Admin admin = adminService.findAdminById(id);
        model.addAttribute("admin", admin);
        return "admins-edit";
    }

    @PostMapping("/admins/edit/{id}")
    public String updateAdmin(@ModelAttribute Admin admin) throws Exception {
        adminService.updateAdmin(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable("id") int id) {
        adminService.deleteAdmin(id);
        return "redirect:/admins";
    }
}
