package per.project.starbucks.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user.id, user.email " +
            "from User user " +
            "where user.email = :email and user.password = :password")
    Optional<User> find(String email, String password);
}
