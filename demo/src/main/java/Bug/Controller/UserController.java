package Bug.Controller;

import Bug.Entity.User;
import Bug.Repository.UserRepository;
import Bug.Service.ServiceImpl.UserServiceImpl;
import Bug.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserRepository userRepository;

    //Sensitive Data Exposure: POST requests do not append data to the URL, whereas GET//
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto user) {
        User existingUser = userServiceImpl.findByUsername(user.getUserName());
        if( userRepository.checkPassword(user.getUserName(), user.getPassword())){
            return ResponseEntity.ok("redirect:/dashboard") ;
        } else {

            return ResponseEntity.status(409).body("Wrong username or password, please try again");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto user) {
        User existingUser = userServiceImpl.findByUsername(user.getUserName());
        if (existingUser != null) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        userServiceImpl.saveUser(user);
        return ResponseEntity.ok("Registration successful");
    }
}
