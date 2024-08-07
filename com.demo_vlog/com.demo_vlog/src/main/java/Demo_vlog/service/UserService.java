package Demo_vlog.service;

import Demo_vlog.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    Optional<User> getUserByUsername(String username); // Add this method
}
