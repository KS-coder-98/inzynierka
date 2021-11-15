package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ReservationDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ConferenceRoomDto conferenceRoomDto;
}
