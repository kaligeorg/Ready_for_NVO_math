package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Lesson;
import f105854.ready_for_nvo_math.repository.LessonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LessonServiceTest {

    @Autowired
    LessonService lessonService;
    @Autowired
    LessonRepository lessonRepository;

    @Test
    void addLesson() {
        Lesson lesson = new Lesson(0, "Аритметична прогересия", null, null, null);
        lessonService.addLesson(lesson);
        Assertions.assertEquals(lessonService.findAll().size(), 4);
    }

    @Test
    void updateLesson() throws Exception{
        Lesson lesson = new Lesson(1, "Аритметична прогересия", null, null, null);
        lessonService.updateLesson(lesson);
        Assertions.assertEquals("Аритметична прогересия", lessonService.findLessonById(lesson.getId()).getTitle());
    }

    @Test
    void deleteLesson() throws Exception{
        Lesson lesson = lessonRepository.save(new Lesson(0, "Аритметична прогересия", null, null, null));
        lessonService.deleteLesson(lesson.getId());
        Assertions.assertFalse(lessonService.findAll().contains(lesson));
    }
}