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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;


    @ManyToMany(mappedBy = "reservations")
    Set<User> eventMembers = new HashSet<>();


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
        return startTime.isBefore(endTime);
    }

    public static Predicate<Reservation> isOverlapping(Reservation reservation) {
        return r -> r.getStartTime().isBefore(reservation.getEndTime())
                && reservation.getStartTime().isBefore(r.getEndTime());
    }
}
