package java.Bug.Service;

import lombok.AllArgsConstructor;
import main.java.Bug.Entity.User;
import main.java.Bug.Exception.ResourceNotFoundException;
import main.java.Bug.Mapper.UserMapper;
import main.java.Bug.Repository.UserRepository;
import main.java.Bug.dto.UserDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder  passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User doesn't exist with given id: " + id));
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User doesn't exist with given id: " + userId)
        );
        user.setUserName(updatedUser.getUserName());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setDateOfBirth(updatedUser.getDateOfBirth());

        User updatedUserObj = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(updatedUserObj);
    }

    @Override
    public void removeUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User doesn't exist with given id: " + userId)
        );
        userRepository.deleteById(user.getId());
    }
    }
//    @Override
//    public Boolean checkRole(Long userId, String role) throws AccessDeniedException {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_" + role))) {
//            return true;
//        } else {
//            throw new AccessDeniedException("User doesn't have the required role.");
//        }
//    }
//}
