package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Lesson;
import f105854.ready_for_nvo_math.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

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

    public void updateLesson(@ModelAttribute Lesson lesson) throws Exception {
        Lesson lessonInDB = lessonRepository.findById(lesson.getId()).orElse(null);
        if (lessonInDB != null) {
            lessonInDB.setTitle(lessonInDB.getTitle());
            lessonInDB.setContent(lesson.getContent());
            lessonInDB.setImage(lesson.getImage());
            lessonInDB.setDiagram(lesson.getDiagram());
            lessonInDB.setLessonsTopic(lesson.getLessonsTopic());
            lessonInDB.setListOfTasksInLesson(lesson.getListOfTasksInLesson());
            lessonInDB.setImage(lesson.getImage());
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
}
