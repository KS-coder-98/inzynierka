package pl.krzysiek.conferenceroombookingsystem.mapper;

import org.mapstruct.Mapper;
import pl.krzysiek.conferenceroombookingsystem.dto.UserDto;
import pl.krzysiek.conferenceroombookingsystem.entity.User;

@Mapper
public interface UserMapper {
    UserDto toUserDto(User user);
}
