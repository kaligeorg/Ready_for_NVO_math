package f105854.ready_for_nvo_math.repository;

import f105854.ready_for_nvo_math.model.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonContentRepository extends JpaRepository<LessonContent, Integer> {
}
