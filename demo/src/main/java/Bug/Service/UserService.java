package main.java.Bug.Service;


import main.java.Bug.Entity.User;
import main.java.Bug.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findByUsername(String username);
    List<UserDto> findAll();
    UserDto getUserById(Long id);
    UserDto updateUser(Long userId, UserDto updatedUser);
    void removeUserById(Long userId);
}
