package f105854.ready_for_nvo_math.repository;

import f105854.ready_for_nvo_math.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
