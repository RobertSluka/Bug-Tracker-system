package java.Bug.Mapper;

import main.java.Bug.Entity.Bug;
import main.java.Bug.dto.BugDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BugMapper {
    BugMapper INSTANCE = Mappers.getMapper(BugMapper.class);

    BugDto bugToBugDto(Bug bug);

    Bug bugDtoToBug(BugDto bugDto);
}
