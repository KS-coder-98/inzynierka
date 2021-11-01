package pl.krzysiek.conferenceroombookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.ReservationRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public Optional<Reservation> addReservation(Long conferenceRoomId, Long organiserId, Reservation reservation) {
        Optional<User> optionalUser = userRepository.findById(organiserId);
        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(conferenceRoomId);
        if (optionalUser.isEmpty() || optionalConferenceRoom.isEmpty() || !reservation.isValid()) {
            return Optional.empty();
        }
        ConferenceRoom conferenceRoom = optionalConferenceRoom.get();
        User user = optionalUser.get();
        boolean isNotOverlapping = conferenceRoom.getReservations().stream()
                .noneMatch(Reservation.isOverlapping(reservation));
        if (isNotOverlapping) {
            return Optional.of(makeReservation(user, conferenceRoom, reservation));
        }
        return Optional.empty();
    }

    public boolean deleteReservation(Long id) {
        var optionalReservation = reservationRepository.findById(id);
        var reservationPresent = optionalReservation.isPresent();
        if (reservationPresent) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Reservation makeReservation(User user, ConferenceRoom conferenceRoom, Reservation reservation) {
        user.getMyReservations().add(reservation);
        conferenceRoom.getReservations().add(reservation);
        return reservationRepository.save(reservation);
    }

}
