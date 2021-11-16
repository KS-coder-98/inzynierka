package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.dto.ReservationDto;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;
import pl.krzysiek.conferenceroombookingsystem.service.ReservationService;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> one(@PathVariable Long id) {
        return reservationService.getReservation(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<ReservationDto> addReservation(@RequestParam Long conferenceRoomId,
                                                         @RequestParam Long organiserId,
                                                         @RequestBody Reservation reservation) {
        return reservationService.addReservation(conferenceRoomId, organiserId, reservation)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id) ?
                ResponseEntity.ok().body(null)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/join")
    public ResponseEntity<ReservationDto> joinToReservation(@RequestParam Long userId, @RequestParam Long reservationId) {
        return reservationService.joinToReservation(userId, reservationId)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.badRequest().build());
    }

}
