package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Task;
import f105854.ready_for_nvo_math.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/tasks")
    public String showTasksPage(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping(path = "/tasks/addToLesson")
    public String showAddTaskPageLesson(Model model) {
        model.addAttribute("task", new Task());
        return "tasks-add";
    }

    @PostMapping(path = "/tasks/addToLesson")
    public String addTaskLesson(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/lessons/" + task.getTasksLesson().getId();
    }

    @GetMapping(path = "/tasks/addToTest")
    public String showAddTaskPageTest(Model model) {
        model.addAttribute("task", new Task());
        return "tasks-add-test";
    }

    @PostMapping(path = "/tasks/addToTest")
    public String addTaskTest(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/tests/" + task.getTasksTest().getId();
    }

    @GetMapping("/tasks/editTest/{id}")
    public String showUpdateFormTest(@PathVariable("id") int id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "tasks-edit-test";
    }

    @PostMapping("/tasks/editTest/{id}")
    public String updateTaskTest(@ModelAttribute Task task) throws Exception {
        taskService.updateTask(task);
        return "redirect:/tests/" + task.getTasksTest().getId();
    }

    @GetMapping("/tasks/editLesson/{id}")
    public String showUpdateFormLesson(@PathVariable("id") int id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "tasks-edit";
    }

    @PostMapping("/tasks/editLesson/{id}")
    public String updateTaskLesson(@ModelAttribute Task task) throws Exception {
        taskService.updateTask(task);
        return "redirect:/lessons/" + task.getTasksLesson().getId();
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTaskFromLesson(@PathVariable("id") int id) {
        int lessonId = taskService.findTaskById(id).getTasksLesson().getId();
        taskService.deleteTask(id);
        return "redirect:/lessons/" + lessonId;
    }

    @GetMapping("/tasks/deleteFromTest/{id}")
    public String deleteTaskFromTest(@PathVariable("id") int id) {
        int testId = taskService.findTaskById(id).getTasksTest().getId();
        taskService.deleteTask(id);
        return "redirect:/tests/" + testId;
    }
}
