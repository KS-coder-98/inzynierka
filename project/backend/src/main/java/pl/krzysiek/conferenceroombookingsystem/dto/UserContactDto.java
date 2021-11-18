package pl.krzysiek.conferenceroombookingsystem.dto;

import lombok.Data;

@Data
public class UserContactDto {
    private String city;
    private String street;
    private int houseNumber;
    private int streetNumber;
    private String postCode;
    private String phoneNumber;
    private String phoneAreaCode;
}
