package Demo_vlog.service;

import Demo_vlog.Model.User;
import Demo_vlog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(User user) {
        // Find the existing user
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update the user's details (excluding password)
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        // Only update password if it's provided and different
        if (!user.getPassword().isEmpty() && !passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByName(username);
    }
}
