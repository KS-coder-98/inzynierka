package pl.krzysiek.conferenceroombookingsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@Entity
@Getter
@Setter
public class Reservation implements Comparable<Reservation> {

    @ManyToMany(mappedBy = "reservations")
    Set<User> eventMembers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_room_id")
    private ConferenceRoom conferenceRoom;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Predicate<Reservation> isOverlapping(Reservation reservation) {
        return r -> r.getStartTime().isBefore(reservation.getEndTime())
                && reservation.getStartTime().isBefore(r.getEndTime());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", eventMembers=" + eventMembers +
                '}';
    }

    @Override
    public int compareTo(Reservation o) {
        return startTime.compareTo(o.getStartTime());
    }

    public boolean isValid() {
        return startTime.isAfter(LocalDateTime.now()) && startTime.isBefore(endTime);
    }
}
