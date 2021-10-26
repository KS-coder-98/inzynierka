package pl.krzysiek.conferenceroombookingsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;


    @ManyToMany(mappedBy = "reservations")
    Set<User> eventMembers = new HashSet<>();

}
