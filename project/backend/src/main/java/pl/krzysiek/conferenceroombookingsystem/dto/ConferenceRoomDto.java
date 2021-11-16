package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ConferenceRoomDto {
    private long id;
    private String name;
    private String description;
    private int capacity;
    private Set<EquipmentDto> equipment;
}
