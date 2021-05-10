package per.project.starbucks.services;

import org.springframework.data.jpa.repository.JpaRepository;
import per.project.starbucks.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
