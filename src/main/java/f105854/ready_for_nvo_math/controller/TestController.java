package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Lesson;
import f105854.ready_for_nvo_math.model.Test;
import f105854.ready_for_nvo_math.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping(path = "/tests/{id}")
    public String viewTest(@PathVariable("id") int id, Model model) {
        Test test = testService.findTestById(id);
        model.addAttribute("test", test);
        return "tests-view";
    }

    @GetMapping(path = "/tests/view/{id}")
    public String viewTestsFromStudents(@PathVariable("id") int id, Model model) {
        Test test = testService.findTestById(id);
        model.addAttribute("test", test);
        return "tests-view-students";
    }

    @GetMapping(path = "/testsInTopicForTeachers/{id}")
    public String showTestsInTopicForTeachers(@PathVariable("id") int id, Model model) {
        List<Test> tests = testService.findTestsByTopic(id);
        model.addAttribute("tests", tests);
        return "tests";
    }

    @GetMapping(path = "/testsInTopicForStudents/{id}")
    public String showTestsInTopicForStudents(@PathVariable("id") int id, Model model) {
        List<Test> tests = testService.findTestsByTopic(id);
        model.addAttribute("tests", tests);
        return "tests-for-students";
    }

    @GetMapping(path = "/tests/add")
    public String showAddTestPage(Model model) {
        model.addAttribute("test", new Test());
        return "tests-add";
    }

    @PostMapping(path = "/tests/add")
    public String addTest(@ModelAttribute Test test) {
        testService.addTest(test);
        return "redirect:/tests/" + test.getId();
    }

    @GetMapping("/tests/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Test test = testService.findTestById(id);
        model.addAttribute("test", test);
        return "tests-edit";
    }

    @PostMapping("/tests/edit/{id}")
    public String updateTest(@ModelAttribute Test test) throws Exception {
        testService.updateTest(test);
        return "redirect:/tests";
    }

    @GetMapping("/tests/delete/{id}")
    public String deleteTest(@PathVariable("id") int id) {
        testService.deleteTest(id);
        return "redirect:/tests";
    }
}
