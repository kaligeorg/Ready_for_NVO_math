package f105854.ready_for_nvo_math.repository;

import f105854.ready_for_nvo_math.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
