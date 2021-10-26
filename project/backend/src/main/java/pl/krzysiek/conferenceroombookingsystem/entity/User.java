package pl.krzysiek.conferenceroombookingsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nick;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "members_reservations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    Set<Reservation> reservations = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "organiser_id")
    Set<Reservation> myReservations = new HashSet<>();
}
