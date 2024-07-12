package java.Bug.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String role;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
}