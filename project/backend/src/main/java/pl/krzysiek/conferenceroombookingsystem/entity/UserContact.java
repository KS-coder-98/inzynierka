package pl.krzysiek.conferenceroombookingsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserContact {

    @Id
    @Column(name = "user_id")
    private Long id;

    @MapsId
    @JoinColumn(name = "user_id")
    @OneToOne(optional = false)
    private User user;

    private String city;
    private String street;
    private int houseNumber;
    private int streetNumber;
    private String postCode;
    private String phoneNumber;
    private String phoneAreaCode;
    private String email;
}
