package Bug.Mapper;

import Bug.Entity.Bug;
import Bug.Entity.User;
import Bug.dto.BugDto;
import Bug.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BugMapper {
    BugMapper INSTANCE = Mappers.getMapper(BugMapper.class);

    BugDto bugToBugDto(Bug bug);

    Bug bugDtoToBug(BugDto bugDto);
}
