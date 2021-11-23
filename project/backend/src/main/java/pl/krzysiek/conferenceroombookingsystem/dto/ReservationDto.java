package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ReservationDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ConferenceRoomDto conferenceRoom;
    private String name;
    private UserDto organiser;
    private Set<UserDto> eventMembers;
}
