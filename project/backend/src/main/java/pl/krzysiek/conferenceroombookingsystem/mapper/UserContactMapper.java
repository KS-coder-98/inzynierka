package pl.krzysiek.conferenceroombookingsystem.mapper;

import org.mapstruct.Mapper;
import pl.krzysiek.conferenceroombookingsystem.dto.UserContactDto;
import pl.krzysiek.conferenceroombookingsystem.entity.User;

@Mapper
public interface UserContactMapper {
    UserContactDto toUserContactDto(User user);
}
