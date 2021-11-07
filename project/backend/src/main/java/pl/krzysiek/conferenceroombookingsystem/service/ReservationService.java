package pl.krzysiek.conferenceroombookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzysiek.conferenceroombookingsystem.dto.ReservationDTO;
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

    public Optional<ReservationDTO> addReservation(Long conferenceRoomId, Long organiserId, Reservation reservation) {
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
            var result = makeReservation(user, conferenceRoom, reservation);
            return Optional.of(ReservationDTO.builder()
                    .startTime(result.getStartTime())
                    .endTime(result.getEndTime())
                    .build());
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
        reservation.setConferenceRoom(conferenceRoom);
        return reservationRepository.save(reservation);
    }

    public Optional<ReservationDTO> joinToReservation(Long userId, Long reservationId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalUser.isEmpty() || optionalReservation.isEmpty()) {
            return Optional.empty();
        }

        var user = optionalUser.get();
        var reservation = optionalReservation.get();
        if (reservation.getConferenceRoom().getCapacity() <= (long) reservation.getEventMembers().size())
            return Optional.empty();
        reservation.getEventMembers().add(user);
        user.getReservations().add(reservation);
        userRepository.save(user);
        reservationRepository.save(reservation);
        return Optional.of(ReservationDTO.builder()
                .startTime(reservation.getStartTime())
                .endTime(reservation.getEndTime())
                .build()
        );
//        return Optional.of(makeReservation(user, reservation));
        //todo
    }

}
