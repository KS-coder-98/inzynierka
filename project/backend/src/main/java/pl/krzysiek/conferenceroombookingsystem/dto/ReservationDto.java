package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ConferenceRoomDto conferenceRoom;
    private String name;
}
