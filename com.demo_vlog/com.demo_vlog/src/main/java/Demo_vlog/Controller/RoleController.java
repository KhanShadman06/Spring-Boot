package Demo_vlog.Controller;

import Demo_vlog.Model.Role;
import Demo_vlog.Model.User;
import Demo_vlog.Repository.RoleRepository;
import Demo_vlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/assign")
    public String assignRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        Optional<User> user = userService.getUserByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.get().getRoles().add(role);
        userService.saveUser(user.orElse(null));
        return "Role assigned successfully";
    }
}
