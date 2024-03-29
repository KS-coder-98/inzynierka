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

    public static final String NORMAL_USER = "USER";
    public static final String ADMIN_USER = "ADMIN";

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nick;
    private String firstName;
    private String lastName;
    //todo in liquibase this field is in userContact, and make this not nullable
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails userDetails;
    @OneToOne(cascade = CascadeType.ALL)
    private UserContact userContact;

    public boolean isValid() {
        //todo make validation for email
        return !email.isBlank();
    }
}
