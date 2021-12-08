package pl.krzysiek.conferenceroombookingsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class ConferenceRoom {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_room_id")
    Set<Equipment> equipment = new HashSet<>();


    @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.REMOVE)
    Set<Reservation> reservations = new HashSet<>();

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int capacity;
}
