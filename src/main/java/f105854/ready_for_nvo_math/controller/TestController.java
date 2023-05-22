package f105854.ready_for_nvo_math.controller;

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

    @GetMapping(path = "/tests")
    public String showTestsPage(Model model) {
        List<Test> tests = testService.findAll();
        model.addAttribute("tests", tests);
        return "tests";
    }

    @GetMapping(path = "/tests/add")
    public String showAddTestPage(Model model) {
        model.addAttribute("test", new Test());
        return "tests-add";
    }

    @PostMapping(path = "/tests/add")
    public String addTest(@ModelAttribute Test test) {
        testService.addTest(test);
        return "redirect:/tests";
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
