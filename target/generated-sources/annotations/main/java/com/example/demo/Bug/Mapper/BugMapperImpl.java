package main.java.com.example.demo.Bug.Mapper;

import javax.annotation.processing.Generated;
import main.java.com.example.demo.Bug.Entity.Bug;
import main.java.com.example.demo.Bug.dto.BugDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-12T10:33:04+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class BugMapperImpl implements BugMapper {

    @Override
    public BugDto bugToBugDto(Bug bug) {
        if ( bug == null ) {
            return null;
        }

        BugDto bugDto = new BugDto();

        return bugDto;
    }

    @Override
    public Bug bugDtoToBug(BugDto bugDto) {
        if ( bugDto == null ) {
            return null;
        }

        Bug bug = new Bug();

        return bug;
    }
}
