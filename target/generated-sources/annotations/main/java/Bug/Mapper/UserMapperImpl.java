package main.java.Bug.Mapper;

import javax.annotation.processing.Generated;
import main.java.Bug.Entity.User;
import main.java.Bug.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T11:23:49+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }
}
