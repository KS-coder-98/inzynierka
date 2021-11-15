package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

@Data
public class ConferenceRoomDto {
    private long id;
    private String name;
    private String description;
    private int capacity;
}
