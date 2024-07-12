package main.java.Bug.Mapper;

import javax.annotation.processing.Generated;
import main.java.com.example.demo.Bug.Entity.Bug;
import main.java.com.example.demo.Bug.dto.BugDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-12T10:50:23+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class BugMapperImpl implements BugMapper {

    @Override
    public BugDto bugToBugDto(Bug bug) {
        if ( bug == null ) {
            return null;
        }

        BugDto bugDto = new BugDto();

        bugDto.setId( bug.getId() );
        bugDto.setBugName( bug.getBugName() );
        bugDto.setPriority( bug.getPriority() );
        bugDto.setBugDate( bug.getBugDate() );
        bugDto.setProjectName( bug.getProjectName() );
        bugDto.setBugType( bug.getBugType() );
        bugDto.setBugLevel( bug.getBugLevel() );
        bugDto.setAssignToDeveloper( bug.getAssignToDeveloper() );
        bugDto.setStatus( bug.getStatus() );

        return bugDto;
    }

    @Override
    public Bug bugDtoToBug(BugDto bugDto) {
        if ( bugDto == null ) {
            return null;
        }

        Bug bug = new Bug();

        bug.setId( bugDto.getId() );
        bug.setBugName( bugDto.getBugName() );
        bug.setPriority( bugDto.getPriority() );
        bug.setBugDate( bugDto.getBugDate() );
        bug.setProjectName( bugDto.getProjectName() );
        bug.setBugType( bugDto.getBugType() );
        bug.setBugLevel( bugDto.getBugLevel() );
        bug.setAssignToDeveloper( bugDto.getAssignToDeveloper() );
        bug.setStatus( bugDto.getStatus() );

        return bug;
    }
}
