package Bug.Service.ServiceImpl;

import Bug.Exception.ResourceNotFoundException;
import Bug.Mapper.UserMapper;
import Bug.Entity.User;
import Bug.Repository.UserRepository;

import Bug.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void removeUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User doesn't exist with given id:" + userId)
        );
        userRepository.deleteById(user.getId());

    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("User doesn't exist with given id :" + id));

        return UserMapper.INSTANCE.userToUserDto(user);
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

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User doesn't exist with given id:" + userId)
        );
        user.setUserName(updatedUser.getUserName());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setDateOfBirth(updatedUser.getDateOfBirth());

        User updatedUserobj = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDto(updatedUserobj);
    }
}
