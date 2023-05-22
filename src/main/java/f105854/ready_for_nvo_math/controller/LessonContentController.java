package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.LessonContent;
import f105854.ready_for_nvo_math.services.LessonContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LessonContentController {
    @Autowired
    private LessonContentService lessonContentService;

    @GetMapping(path = "/lessonContents")
    public String showLessonContentsPage(Model model) {
        List<LessonContent> lessonContents = lessonContentService.findAll();
        model.addAttribute("lessonContents", lessonContents);
        return "lessonContents";
    }

    @GetMapping(path = "/lessonContents/add")
    public String showAddLessonContentPage(Model model) {
        model.addAttribute("lessonContent", new LessonContent());
        return "lessonContents-add";
    }

    @PostMapping(path = "/lessonContents/add")
    public String addLessonContent(@ModelAttribute LessonContent lessonContent) {
        lessonContentService.addLessonContent(lessonContent);
        return "redirect:/lessonContents";
    }

    @GetMapping("/lessonContents/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        LessonContent lessonContent = lessonContentService.findLessonContentById(id);
        model.addAttribute("lessonContent", lessonContent);
        return "lessonContents-edit";
    }

    @PostMapping("/lessonContents/edit/{id}")
    public String updateLessonContent(@ModelAttribute LessonContent lessonContent) throws Exception {
        lessonContentService.updateLessonContent(lessonContent);
        return "redirect:/lessonContents";
    }

    @GetMapping("/lessonContents/delete/{id}")
    public String deleteLessonContent(@PathVariable("id") int id) {
        lessonContentService.deleteLessonContent(id);
        return "redirect:/lessonContents";
    }
}
