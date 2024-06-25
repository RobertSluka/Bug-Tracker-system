package Bug.Service.ServiceImpl;

import Bug.Mapper.UserMapper;
import Bug.Entity.User;
import Bug.Repository.UserRepository;
import Bug.Service.UserService;
import Bug.Service.UserService;
import Bug.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements Bug.Service.UserService {

    private final UserRepository userRepository;

    public void saveUser(UserDto userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        userRepository.save(user);
    }

    public void removeDeveloperById(User developer) {
        userRepository.deleteById(developer.getId());

    }

    public Optional<User> getDeveloperById(Long id) {
        return userRepository.findById(id);
    }

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
}
