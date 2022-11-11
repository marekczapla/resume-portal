package pl.markopolo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.markopolo.models.User;
import pl.markopolo.models.UserProfile;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUserName(String userName);
}
