package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String nick;
    private String firstName;
    private String lastName;
}
