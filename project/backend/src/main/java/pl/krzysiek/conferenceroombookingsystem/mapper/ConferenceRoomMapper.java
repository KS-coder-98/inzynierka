package pl.krzysiek.conferenceroombookingsystem.mapper;

import org.mapstruct.Mapper;
import pl.krzysiek.conferenceroombookingsystem.dto.ConferenceRoomDto;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;

@Mapper
public interface ConferenceRoomMapper {
    ConferenceRoomDto toConferenceRoomDto(ConferenceRoom conferenceRoom);
}
