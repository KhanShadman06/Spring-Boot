package Demo_vlog.service;

import Demo_vlog.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Page<User> getAllUsers(Pageable pageable);

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(Long id, User user);

    void deleteUser(Long id);

    Optional<User> getUserByUsername(String username);

    Optional<User> findByUsername(String username);
}
