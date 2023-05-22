package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Teacher;
import f105854.ready_for_nvo_math.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;

    @GetMapping(path = "/teachers")
    public String showTeachersPage(Model model) {
        List<Teacher> teachers = teacherService.findAll(model);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping(path = "/teachers/add")
    public String showAddTeacherPage(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers-add";
    }

    @PostMapping(path = "/teachers/add")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.findTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teachers-edit";
    }

    @PostMapping("/teachers/edit/{id}")
    public String updateTeacher(@ModelAttribute Teacher teacher) throws Exception {
        teacherService.updateTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
