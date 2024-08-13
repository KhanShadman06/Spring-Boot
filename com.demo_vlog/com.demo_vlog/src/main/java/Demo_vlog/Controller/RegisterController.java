package Demo_vlog.Controller;

import Demo_vlog.DTO.RegistrationRequest;
import Demo_vlog.Model.User;
import Demo_vlog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody RegistrationRequest request) {
        User registeredUser = userService.registerUser(request);
        return ResponseEntity.ok(registeredUser);
    }
}
