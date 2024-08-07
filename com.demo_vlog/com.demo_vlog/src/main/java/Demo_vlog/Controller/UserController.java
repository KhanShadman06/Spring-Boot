package Demo_vlog.Controller;

import Demo_vlog.Model.User;
import Demo_vlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username")
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
