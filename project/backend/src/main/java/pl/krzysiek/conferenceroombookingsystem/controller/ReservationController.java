package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.ReservationRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestParam Long conferenceRoomId,
                                                      @RequestParam Long organiserId,
                                                      @RequestBody Reservation reservation){
        Optional<User> optionalUser = userRepository.findById(organiserId);
        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(conferenceRoomId);
        if ( optionalUser.isEmpty() || optionalConferenceRoom.isEmpty() ){
            return ResponseEntity.notFound().build();
        }
        var user = optionalUser.get();
        var conferenceRoom = optionalConferenceRoom.get();
        user.getMyReservations().add(reservation);
        // todo check is reservation overlaps
        conferenceRoom.getReservations().add(reservation);
        reservation = reservationRepository.save(reservation);
        return ResponseEntity.ok().body(reservation);
    }

}
