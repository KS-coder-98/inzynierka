package pl.krzysiek.conferenceroombookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzysiek.conferenceroombookingsystem.dto.ReservationDto;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.mapper.ReservationMapper;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.ReservationRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;

    public Optional<ReservationDto> addReservation(Long conferenceRoomId, String mail, Reservation reservation) {
        Optional<User> optionalUser = userRepository.findByEmail(mail);
        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(conferenceRoomId);
        if (optionalUser.isEmpty() || optionalConferenceRoom.isEmpty()) {
            return Optional.empty();
        }
        ConferenceRoom conferenceRoom = optionalConferenceRoom.get();
        User user = optionalUser.get();
        reservation.setOrganiser(user);
        boolean isNotOverlapping = conferenceRoom.getReservations().stream()
                .noneMatch(Reservation.isOverlapping(reservation));
        if (isNotOverlapping) {
            var result = makeReservation(user, conferenceRoom, reservation);
            reservationMapper.toReservationDto(result);
            return Optional.of(reservationMapper.toReservationDto(result));
        }
        return Optional.empty();
    }

    public Optional<ReservationDto> getReservation(Long reservationId) {
        Optional<Reservation> byId = reservationRepository.findById(reservationId);
        if (byId.isPresent()) {
            return byId.map(reservationMapper::toReservationDto);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteReservation(Long id) {
        var optionalReservation = reservationRepository.findById(id);
        var reservationPresent = optionalReservation.isPresent();
        if (reservationPresent) {
            optionalReservation.get().getEventMembers().forEach(user -> {
                user.getMyReservations().remove(optionalReservation.get());
                userRepository.save(user);
            });
            optionalReservation.get().getEventMembers().clear();
            reservationRepository.delete(optionalReservation.get());
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

    public Optional<ReservationDto> joinToReservation(String mail, Long reservationId) {
        Optional<User> optionalUser = userRepository.findByEmail(mail);
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
        return Optional.of(reservationMapper.toReservationDto(reservation));
        //todo better validation
    }

    public List<ReservationDto> getUpcomingUserEvents(String mail) {
        User user = userRepository.findByEmail(mail).orElseThrow();
        return user.getReservations().stream()
                .filter(reservation -> reservation.getStartTime().isAfter(LocalDateTime.now())
                        && reservation.getStartTime().isBefore(LocalDateTime.now().plusDays(3)))
                .map(reservationMapper::toReservationDto)
                .collect(Collectors.toList());
    }

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toReservationDto)
                .collect(Collectors.toList());
    }

    public ReservationDto cancelReservation(String mail, Long reservationId) {
        User user = userRepository.findByEmail(mail).orElseThrow();
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
        reservation.getEventMembers().remove(user);
        user.getReservations().remove(reservation);
        userRepository.save(user);
        reservationRepository.save(reservation);
        return reservationMapper.toReservationDto(reservation);
    }

}
