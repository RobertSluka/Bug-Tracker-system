package main.java.Bug.Controller;

import main.java.Bug.Entity.User;
import main.java.Bug.Repository.UserRepository;
import main.java.Bug.Service.UserServiceImpl;
import main.java.Bug.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUserName());
        if (userRepository.checkPassword(user.getUserName(), user.getPassword())) {
            return ResponseEntity.ok("redirect:/dashboard");
        } else {

            return ResponseEntity.status(409).body("Wrong username or password, please try again");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto user) {
        User existingUser = userService.findByUsername(user.getUserName());
        if (existingUser != null) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("Registration successful");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        UserDto existingUser = userService.getUserById(userId);
        if (existingUser == null) {
            return ResponseEntity.status(409).body("Username does not exist");
        } else {
            userService.removeUserById(userId);
            return ResponseEntity.ok("User deleted successfully");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updatedUser) {
        UserDto userDto = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(userDto);
    }
}