package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Task;
import f105854.ready_for_nvo_math.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public void addTask(@ModelAttribute Task task) {
        taskRepository.save(task);
    }

    public Task findTaskById(@PathVariable("id") int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        return task;
    }

    public void updateTask(@ModelAttribute Task task) throws Exception {
        Task taskInDB = taskRepository.findById(task.getId()).orElse(null);
        if (taskInDB != null) {
            taskInDB.setCondition(taskInDB.getCondition());
            taskInDB.setAnswer1(task.getAnswer1());
            taskInDB.setAnswer2(task.getAnswer2());
            taskInDB.setAnswer3(task.getAnswer3());
            taskInDB.setAnswer4(task.getAnswer4());
            taskInDB.setCorrectAnswer(task.getCorrectAnswer());
            taskInDB.setImage(task.getImage());
            taskRepository.save(taskInDB);
        } else {
            throw new Exception("Task not found!");
        }
    }


    public void deleteTask(@PathVariable("id") int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        taskRepository.delete(task);
    }
}
