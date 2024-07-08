package Bug.Service;

import Bug.Entity.Bug;
import Bug.dto.BugDto;

import java.util.List;

public interface BugService {
    void saveBug(BugDto bugDto);
    Bug findByBugName(String bugName);
    List<BugDto> findAll();
}
