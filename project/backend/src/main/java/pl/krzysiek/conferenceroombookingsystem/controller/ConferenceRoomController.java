package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.dto.ConferenceRoomDto;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.service.ConferenceRoomService;

@RestController
@RequestMapping("conference-room")
@RequiredArgsConstructor
public class ConferenceRoomController {

    private final ConferenceRoomService conferenceRoomService;

    @GetMapping("{id}")
    public ResponseEntity<ConferenceRoomDto> one(@PathVariable Long id) {
        return conferenceRoomService.getConferenceRoomById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<ConferenceRoomDto>> all(Pageable pageable) {
        return ResponseEntity.ok().body(conferenceRoomService.getAllConferenceRooms(pageable));
    }

    @GetMapping("/create")
    public ResponseEntity<ConferenceRoomDto> create(@RequestBody ConferenceRoom conferenceRoom) {
        return new ResponseEntity<>(conferenceRoomService.create(conferenceRoom), HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<ConferenceRoomDto> updateConferenceRoom(@RequestBody ConferenceRoom room) {
        return conferenceRoomService.update(room)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ConferenceRoomDto> deleteConferenceRoom(@PathVariable(value = "id") Long conferenceId) {
        return conferenceRoomService.delete(conferenceId) ?
                ResponseEntity.ok().body(null) : ResponseEntity.notFound().build();
    }

    @GetMapping("/add-eq-to-cr")
    public ResponseEntity<ConferenceRoomDto> addEquipmentToConferenceRoom(@RequestParam Long conferenceRoomId, @RequestParam Long equipmentId) {
        return conferenceRoomService.addEquipment(conferenceRoomId, equipmentId)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }
}
