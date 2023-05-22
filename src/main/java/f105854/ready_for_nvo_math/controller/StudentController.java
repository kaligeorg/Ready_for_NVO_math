package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Student;
import f105854.ready_for_nvo_math.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/students")
    public String showStudentsPage(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping(path = "/students/add")
    public String showAddStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "students-add";
    }

    @PostMapping(path = "/students/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "students-edit";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@ModelAttribute Student student) throws Exception {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
