package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ReservationDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}






