//package main.java.Bug.Service.ServiceImpl;
//
//import Bug.Service.BugService;
//import lombok.AllArgsConstructor;
//import main.java.Bug.Entity.Bug;
//import main.java.Bug.Mapper.BugMapper;
//import main.java.Bug.Repository.BugRepository;
//import main.java.Bug.dto.BugDto;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class BugServiceImpl implements BugService {
//
//    private final BugRepository bugRepository;
//
//
//    @Override
//    public void saveBug(BugDto bugDto) {
//        Bug bug = new Bug();
//        bug.setBugName(bugDto.getBugName());
//        bug.setPriority(bugDto.getPriority());
//        bug.setBugDate(bugDto.getBugDate());
//        bug.setProjectName(bugDto.getProjectName());
//        bug.setBugType(bugDto.getBugType());
//        bug.setBugLevel(bugDto.getBugLevel());
//        bug.setAssignToDeveloper(bugDto.getAssignToDeveloper());
//        bug.setStatus(bugDto.getStatus());
//        try {
//            bugRepository.save(bug);
//        }catch (DataIntegrityViolationException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Bug findByBugName(String bugName) {
//        return bugRepository.findByBugName(bugName);
//    }
//
//    @Override
//    public List<BugDto> findAll() {
//        List<Bug> bugs = bugRepository.findAll();
//        return bugs.stream()
//                .map(BugMapper.INSTANCE::bugToBugDto)
//                .collect(Collectors.toList());
//    }
//}
