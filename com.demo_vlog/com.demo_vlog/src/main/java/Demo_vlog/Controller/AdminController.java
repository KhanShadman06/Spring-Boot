package Demo_vlog.Controller;

import Demo_vlog.Model.User;
import Demo_vlog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
