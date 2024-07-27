package Demo_vlog.service;

import Demo_vlog.Model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
}
