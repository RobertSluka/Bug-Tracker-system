package main.java.Bug.Controller;


import main.java.Bug.Repository.BugRepository;
import main.java.Bug.Service.BugServiceImpl;
import main.java.Bug.dto.BugDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@Controller
@RequestMapping("/bug")
public class BugController {
    @Autowired
    private BugServiceImpl bugServiceImpl;
    @Autowired
    private BugRepository bugRepository;


    @PostMapping("/creation")
    public ResponseEntity<String> addBug(@RequestBody BugDto bugDto) {
        if(!bugRepository.validateBug(bugDto.getBugName(),bugDto.getProjectName())){

            bugServiceImpl.saveBug(bugDto);
            return ResponseEntity.ok("Bug added successfully. Redirecting to dashboard...");
        } else {
            return ResponseEntity.status(409).body("A bug with the same name already exists in this project.");
        }
    }

    @GetMapping("/allBugs")
    public ResponseEntity<String> viewBugs() {
        if(bugRepository.count()>0){

            System.out.println(bugRepository.findAll());
            return ResponseEntity.ok("All bugs found");
        } else {
            return ResponseEntity.status(409).body("There aren't any bugs found.");
        }
    }

}
