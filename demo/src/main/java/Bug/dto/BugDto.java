package main.java.Bug.dto;




import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BugDto {

    private long id;

    @NotBlank(message = "Bug name is required and cannot be blank")
    private String bugName;

    @NotBlank(message = "Priority is required and cannot be blank")
    private String priority;

    @NotBlank(message = "Bug date is required and cannot be blank")
    private String bugDate;

    @NotBlank(message = "Project name is required and cannot be blank")
    private String projectName;

    @NotBlank(message = "Bug type is required and cannot be blank")
    private String bugType;

    @NotBlank(message = "Bug level is required and cannot be blank")
    private String bugLevel;

    @NotBlank(message = "Assign to developer is required and cannot be blank")
    private String assignToDeveloper;

    @NotBlank(message = "Status is required and cannot be blank")
    private String status;
}
