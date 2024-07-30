package Demo_vlog.Repository;

import Demo_vlog.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
