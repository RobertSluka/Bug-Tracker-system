package java.Bug.Controller;//package Bug.Controller;
//
//import Bug.Entity.Role;
//import Bug.Entity.User;
//import Bug.Repository.RoleRepository;
//import Bug.Repository.UserRepository;
//import Bug.Security.JWTGenerator;
//import Bug.dto.AuthResponseDTO;
//import Bug.dto.LoginDto;
//import Bug.dto.RegisterDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private AuthenticationManager  authenticationManager;
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//    private JWTGenerator jwtGenerator;
//    @Autowired
//    public AuthController(PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository, AuthenticationManager authenticationManager,JWTGenerator jwtGenerator) {
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//        this.userRepository = userRepository;
//        this.authenticationManager = authenticationManager;
//        this.jwtGenerator = jwtGenerator;
//    }
//
//    @PostMapping("login")
//    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginDto.getUsername(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = jwtGenerator.generateToken(authentication);
//
//        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
//    }
//
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
//        if(userRepository.existsByUserName(registerDto.getUsername())) {
//            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
//        }
//        User user = new User();
//        user.setUserName(registerDto.getUsername());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//
//        Role roles = roleRepository.findByName("USER").get();
//        user.setRoles(Collections.singletonList(roles));
//
//        userRepository.save(user);
//        return new ResponseEntity<>("User registered success", HttpStatus.OK);
//    }
//
//
//}
