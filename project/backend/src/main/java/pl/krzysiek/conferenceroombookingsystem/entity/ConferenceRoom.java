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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private int capacity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_room_id")
    Set<Equipment> equipment = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_room_id")
    Set<Reservation> reservations = new HashSet<>();
}
