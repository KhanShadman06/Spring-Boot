package Demo_vlog.Repository;

import Demo_vlog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);  // Changed from findByUsername to findByName
}
