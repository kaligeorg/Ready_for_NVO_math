package f105854.ready_for_nvo_math.repository;

import f105854.ready_for_nvo_math.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByEmail(String email);
}
