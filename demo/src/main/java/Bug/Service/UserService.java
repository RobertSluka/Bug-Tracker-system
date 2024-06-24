package Bug.Service;

import Bug.Model.User;
import Bug.Repository.UserRepository;
import Bug.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository useRepository;

    public void saveUser(UserDto userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        useRepository.save(user);
    }

    public void removeDeveloperById(User developer) {
        useRepository.deleteById(developer.getId());

    }

    public Optional<User> getDeveloperById(Long id) {
        return useRepository.findById(id);
    }

    public User findByUsername(String username) {
        return useRepository.findByUserName(username);
    }
}
