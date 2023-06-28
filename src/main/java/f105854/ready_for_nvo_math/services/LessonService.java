package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Lesson;
import f105854.ready_for_nvo_math.model.LessonContent;
import f105854.ready_for_nvo_math.model.Task;
import f105854.ready_for_nvo_math.repository.LessonContentRepository;
import f105854.ready_for_nvo_math.repository.LessonRepository;
import f105854.ready_for_nvo_math.repository.TaskRepository;
import f105854.ready_for_nvo_math.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private LessonContentRepository lessonContentRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Lesson> findAll() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons;
    }

    public void addLesson(@ModelAttribute Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public Lesson findLessonById(@PathVariable("id") int id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid lesson ID: " + id));
        return lesson;
    }

    public List<Lesson> findLessonsByTopic(@PathVariable("id") int id){
        List<Lesson> lessons = lessonRepository.findAll();
        List<Lesson> lessonsInTopic = new ArrayList<Lesson>();
        for(Lesson lesson : lessons){
            if(lesson.getLessonsTopic().getId() == id)
                lessonsInTopic.add(lesson);
        }
        return lessonsInTopic;
    }

    public void updateLesson(@ModelAttribute Lesson lesson) throws Exception {
        Lesson lessonInDB = lessonRepository.findById(lesson.getId()).orElse(null);
        if (lessonInDB != null) {
            lessonInDB.setTitle(lesson.getTitle());
            lessonInDB.setLessonContents(lesson.getLessonContents());
            lessonInDB.setLessonsTopic(lesson.getLessonsTopic());
            lessonInDB.setListOfTasksInLesson(lesson.getListOfTasksInLesson());
            lessonRepository.save(lessonInDB);
        } else {
            throw new Exception("Lesson not found!");
        }
    }


    public void deleteLesson(@PathVariable("id") int id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lesson ID: " + id));
        lessonRepository.delete(lesson);
    }

    public int findTopicsID(@PathVariable("id") int id){
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid lesson ID: " + id));
        return lesson.getLessonsTopic().getId();
    }
}
