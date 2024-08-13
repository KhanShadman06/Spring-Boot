package Demo_vlog.service;

import Demo_vlog.DTO.RegistrationRequest;
import Demo_vlog.Model.Role;
import Demo_vlog.Model.User;
import Demo_vlog.Repository.RoleRepository;
import Demo_vlog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(user.getName()); // Update the name field
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
                    existingUser.setEmail(user.getEmail());
                    existingUser.setEnabled(user.isEnabled());
                    existingUser.setRoles(user.getRoles());
                    return userRepository.save(existingUser);
                });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public User registerUser(RegistrationRequest request) {
        User user = new User();
        user.setName(request.getName()); // Set the name field from the request
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setEnabled(true);

        // Set default role as USER
        Role userRole = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        if (userRole != null) {
            roles.add(userRole);
        }
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User createAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        if (adminRole != null) {
            roles.add(adminRole);
        }
        user.setRoles(roles);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    public User assignAdminRole(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    Role adminRole = roleRepository.findByName("ROLE_ADMIN");
                    Set<Role> roles = user.getRoles();
                    if (adminRole != null) {
                        roles.add(adminRole);
                    }
                    user.setRoles(roles);
                    return userRepository.save(user);
                }).orElse(null);
    }
}
