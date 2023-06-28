package f105854.ready_for_nvo_math.services;

import constant.CorrectAnswer;
import f105854.ready_for_nvo_math.model.Task;
import f105854.ready_for_nvo_math.model.Topic;
import f105854.ready_for_nvo_math.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepository taskRepository;

    @Test
    void addTask() {
        Task taskAdd = new Task(0, "Намерете повърхнината на конус с образуваща 5 и радиус 3", "5S",
                "163", "6S", "193", CorrectAnswer.C, null, null, null,null);
        taskService.addTask(taskAdd);
        Assertions.assertEquals(taskService.findAll().size(), 8);
    }

    @Test
    void updateTask() throws Exception{
        Task taskUpdate = new Task(3, "Намерете повърхнината на конус с образуваща 5 и радиус 3.", "5S",
                "163", "6S", "193", CorrectAnswer.C, null, null, null,null);
        taskService.updateTask(taskUpdate);
        Assertions.assertEquals("Намерете повърхнината на конус с образуваща 5 и радиус 3.", taskService.findTaskById(taskUpdate.getId()).getCondition());
    }

    @Test
    void deleteTask() throws Exception{
        Task task = taskRepository.save(new Task(0, "Намерете повърхнината на конус с образуваща 5 и радиус 3.", "5S",
                "163", "6S", "193", CorrectAnswer.C, null, null, null,null));
        taskService.deleteTask(task.getId());
        Assertions.assertFalse(taskService.findAll().contains(task));
    }
}