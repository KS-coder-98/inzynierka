package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;
import pl.krzysiek.conferenceroombookingsystem.service.ReservationService;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestParam Long conferenceRoomId,
                                                      @RequestParam Long organiserId,
                                                      @RequestBody Reservation reservation) {
        return reservationService.addReservation(conferenceRoomId, organiserId, reservation)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id) ?
                ResponseEntity.ok().body(null)
                : ResponseEntity.notFound().build();
    }

}
