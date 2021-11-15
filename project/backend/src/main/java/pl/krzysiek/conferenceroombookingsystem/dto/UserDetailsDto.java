package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDetailsDto {
    private LocalDate dateOfBirth;
    //todo rework as enum later
    private String typeOfMembers;
}
