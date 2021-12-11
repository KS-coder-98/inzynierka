package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.dto.ReservationDto;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;
import pl.krzysiek.conferenceroombookingsystem.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/user-reservation")
    public ResponseEntity<List<ReservationDto>> getUserUpcomingEvents(@RequestParam String mail) {
        return ResponseEntity.ok(reservationService.getUpcomingUserEvents(mail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> one(@PathVariable Long id) {
        return reservationService.getReservation(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<ReservationDto> addReservation(@RequestParam Long conferenceRoomId,
                                                         @RequestParam String mail,
                                                         @RequestBody Reservation reservation) {
        return reservationService.addReservation(conferenceRoomId, mail, reservation)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping
    public ResponseEntity<Reservation> deleteReservation(@RequestParam Long reservationId) {
        return reservationService.deleteReservation(reservationId) ?
                ResponseEntity.ok().body(null)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/join")
    public ResponseEntity<ReservationDto> joinToReservation(@RequestParam String mail, @RequestParam Long reservationId) {
        return reservationService.joinToReservation(mail, reservationId)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/cancel-reservation")
    public ResponseEntity<ReservationDto> cancelReservation(@RequestParam String mail, @RequestParam Long reservationId) {
        return ResponseEntity.ok(reservationService.cancelReservation(mail, reservationId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationDto>> getAll() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

}
