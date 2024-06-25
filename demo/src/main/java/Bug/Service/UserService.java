package Bug.Service;

import Bug.Entity.User;
import Bug.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserDto userDTO);
    void removeDeveloperById(User developer);
    Optional<User> getDeveloperById(Long id);
    User findByUsername(String username);
    List<UserDto> findAll();
}
