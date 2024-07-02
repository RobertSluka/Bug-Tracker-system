package Bug.Service;

import Bug.Entity.User;
import Bug.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDTO);
    void removeUserById(Long userId);
    UserDto getUserById(Long id);
    User findByUsername(String username);
    List<UserDto> findAll();
    UserDto updateUser(Long userId, UserDto updatedUser);
}
