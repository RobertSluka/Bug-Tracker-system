package main.java.Bug.Service;

import main.java.Bug.Entity.Bug;
import main.java.Bug.Entity.User;
import main.java.Bug.dto.BugDto;
import main.java.Bug.dto.UserDto;

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