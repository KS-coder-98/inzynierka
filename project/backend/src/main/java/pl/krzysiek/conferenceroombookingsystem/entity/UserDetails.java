package pl.krzysiek.conferenceroombookingsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserDetails {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @MapsId
    @JoinColumn(name = "user_id")
    @OneToOne(optional = false)
    private User user;

    private LocalDate dateOfBirth;
    //todo rework as enum later
    private String typeOfMembers;
}
