package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.LessonContent;
import f105854.ready_for_nvo_math.repository.LessonContentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LessonContentServiceTest {
    @Autowired
    LessonContentService lessonContentService;
    @Autowired
    LessonContentRepository lessonContentRepository;

    @Test
    void addLessonContent() {
        LessonContent lessonContent = new LessonContent(0, "Аритметичната прогресия е числова редица, в която всеки член след първия се получава от своя предходен, като се прибави едно и също число.", null, null);
        lessonContentService.addLessonContent(lessonContent);
        Assertions.assertEquals(lessonContentService.findAll().size(), 6);
    }

    @Test
    void updateLessonContent() throws Exception{
        LessonContent lessonContent = new LessonContent(1, "Аритметичната прогресия е числова редица, в която всеки член след първия се получава от своя предходен, като се прибави едно и също число.", null, null);
        lessonContentService.updateLessonContent(lessonContent);
        Assertions.assertEquals("Аритметичната прогресия е числова редица, в която всеки член след първия се получава от своя предходен, като се прибави едно и също число.", lessonContent.getContent());
    }

    @Test
    void deleteLessonContent() throws Exception{
        LessonContent lessonContent = lessonContentRepository.save(new LessonContent(0, "Аритметичната прогресия е числова редица, в която всеки член след първия се получава от своя предходен, като се прибави едно и също число.", null, null));
        lessonContentService.deleteLessonContent(lessonContent.getId());
        Assertions.assertFalse(lessonContentService.findAll().contains(lessonContent));
    }
}