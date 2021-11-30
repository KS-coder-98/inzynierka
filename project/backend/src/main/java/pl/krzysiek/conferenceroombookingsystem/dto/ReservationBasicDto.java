package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationBasicDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String name;
    private UserDto organiser;
}
