package Bug.Service.ServiceImpl;

import Bug.Entity.Bug;
import Bug.Entity.User;
import Bug.Mapper.BugMapper;
import Bug.Mapper.UserMapper;
import Bug.Repository.BugRepository;
import Bug.Repository.UserRepository;
import Bug.Service.BugService;
import Bug.dto.BugDto;
import Bug.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;


    @Override
    public void saveBug(BugDto bugDto) {
        Bug bug = new Bug();
        bug.setBugName(bugDto.getBugName());
        bug.setPriority(bugDto.getPriority());
        bug.setBugDate(bugDto.getBugDate());
        bug.setProjectName(bugDto.getProjectName());
        bug.setBugType(bugDto.getBugType());
        bug.setBugLevel(bugDto.getBugLevel());
        bug.setAssignToDeveloper(bugDto.getAssignToDeveloper());
        bug.setStatus(bugDto.getStatus());
        try {
            bugRepository.save(bug);
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
        }
    }

    @Override
    public Bug findByBugName(String bugName) {
        return bugRepository.findByBugName(bugName);
    }

    @Override
    public List<BugDto> findAll() {
        List<Bug> bugs = bugRepository.findAll();
        return bugs.stream()
                .map(BugMapper.INSTANCE::bugToBugDto)
                .collect(Collectors.toList());
    }
}
