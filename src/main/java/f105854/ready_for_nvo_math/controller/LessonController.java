package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Lesson;
import f105854.ready_for_nvo_math.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping(path = "/lessons")
    public String showLessonsPage(Model model) {
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);
        return "lessons";
    }

    @GetMapping(path = "/lessons/add")
    public String showAddLessonPage(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "lessons-add";
    }

    @PostMapping(path = "/lessons/add")
    public String addLesson(@ModelAttribute Lesson lesson) {
        lessonService.addLesson(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Lesson lesson = lessonService.findLessonById(id);
        model.addAttribute("lesson", lesson);
        return "lessons-edit";
    }

    @PostMapping("/lessons/edit/{id}")
    public String updateLesson(@ModelAttribute Lesson lesson) throws Exception {
        lessonService.updateLesson(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/delete/{id}")
    public String deleteLesson(@PathVariable("id") int id) {
        lessonService.deleteLesson(id);
        return "redirect:/lessons";
    }
}
