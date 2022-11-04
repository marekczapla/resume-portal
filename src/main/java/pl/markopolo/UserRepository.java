package pl.markopolo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.markopolo.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
