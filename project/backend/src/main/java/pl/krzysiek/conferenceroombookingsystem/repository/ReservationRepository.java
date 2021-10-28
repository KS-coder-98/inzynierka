package pl.krzysiek.conferenceroombookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
