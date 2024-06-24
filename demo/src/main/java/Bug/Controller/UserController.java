package Bug.Controller;

import Bug.Model.User;
import Bug.Service.UserService;
import Bug.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
//        User user = userService.findByUsername(username);
//        if (user != null && user.getPassword().equals(password)) {
//            // Authentication successful
//            return "redirect:/dashboard"; // or wherever you want to redirect after login
//        } else {
//            // Authentication failed
//            return "login";
//        }
//    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto user) {
        User existingUser = userService.findByUsername(user.getUserName());
        if (existingUser != null) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("Registration successful");
    }
}
