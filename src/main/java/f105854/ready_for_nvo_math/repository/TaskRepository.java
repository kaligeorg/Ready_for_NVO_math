package f105854.ready_for_nvo_math.repository;

import f105854.ready_for_nvo_math.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
