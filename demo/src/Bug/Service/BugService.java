package Bug.Service;


import main.java.Bug.Entity.Bug;
import main.java.Bug.dto.BugDto;

import java.util.List;

public interface BugService {
    void saveBug(BugDto bugDto);
    Bug findByBugName(String bugName);
    List<BugDto> findAll();
}
