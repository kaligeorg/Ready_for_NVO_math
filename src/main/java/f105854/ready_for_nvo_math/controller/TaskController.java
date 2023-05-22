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

    @GetMapping(path = "/tasks/add")
    public String showAddTaskPage(Model model) {
        model.addAttribute("task", new Task());
        return "tasks-add";
    }

    @PostMapping(path = "/tasks/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "tasks-edit";
    }

    @PostMapping("/tasks/edit/{id}")
    public String updateTask(@ModelAttribute Task task) throws Exception {
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
