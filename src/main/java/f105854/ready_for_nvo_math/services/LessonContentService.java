package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.LessonContent;
import f105854.ready_for_nvo_math.repository.LessonContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LessonContentService {
    @Autowired
    private LessonContentRepository lessonContentRepository;

    public List<LessonContent> findAll() {
        List<LessonContent> LessonContent = lessonContentRepository.findAll();
        return LessonContent;
    }

    public void addLessonContent(@ModelAttribute LessonContent lessonContent) {
        lessonContentRepository.save(lessonContent);
    }

    public LessonContent findLessonContentById(@PathVariable("id") int id) {
        LessonContent lessonContent = lessonContentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid lessonContent ID: " + id));
        return lessonContent;
    }

    public void updateLessonContent(@ModelAttribute LessonContent lessonContent) throws Exception {
        LessonContent lessonContentInDB = lessonContentRepository.findById(lessonContent.getId()).orElse(null);
        if (lessonContentInDB != null) {
            lessonContentInDB.setContent(lessonContent.getContent());
            lessonContentInDB.setImage(lessonContent.getImage());
            lessonContentRepository.save(lessonContentInDB);
        } else {
            throw new Exception("Lesson not found!");
        }
    }


    public void deleteLessonContent(@PathVariable("id") int id) {
        LessonContent lessonContent = lessonContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lessonContent ID: " + id));
        lessonContentRepository.delete(lessonContent);
    }
}
