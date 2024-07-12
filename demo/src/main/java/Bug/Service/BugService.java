package java.Bug.Service;


import java.Bug.Entity.Bug;
import java.Bug.Entity.User;
import java.Bug.dto.BugDto;
import java.Bug.dto.UserDto;
import java.util.List;

public interface BugService {
    void saveBug(BugDto bugDto);
    User findByBugname(String bugName);

    Bug findByBugName(String bugName);

    List<BugDto> findAll();
    UserDto getBugById(Long id);
    UserDto updateBug(Long bugId, BugDto updatedBug);
    void removeBugById(Long bugId);
}