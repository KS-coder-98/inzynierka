package pl.krzysiek.conferenceroombookingsystem.mapper;

import org.mapstruct.Mapper;
import pl.krzysiek.conferenceroombookingsystem.dto.UserDetailsDto;
import pl.krzysiek.conferenceroombookingsystem.entity.UserDetails;

@Mapper
public interface UserDetailsMapper {
    UserDetailsDto toUserDetailsDto(UserDetails userDetails);
}
