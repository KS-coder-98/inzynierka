package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;

import java.util.Optional;

@RestController
@RequestMapping("conference-room")
@RequiredArgsConstructor
public class ConferenceRoomController {


    private final ConferenceRoomRepository conferenceRoomRepository;


    @GetMapping("/{id}")
    public ResponseEntity<ConferenceRoom> one(@PathVariable Long id) {
        return conferenceRoomRepository.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<ConferenceRoom>> all(Pageable pageable) {
        var page = conferenceRoomRepository.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<ConferenceRoom> create(@RequestBody ConferenceRoom conferenceRoom) {
        ConferenceRoom conferenceRoom1 = conferenceRoomRepository.save(conferenceRoom);
        return new ResponseEntity<>(conferenceRoom1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConferenceRoom> updateConferenceRoom(@PathVariable(value = "id") Long conferenceRoomId,
                                                               @RequestBody ConferenceRoom room) {
        conferenceRoomRepository.setConferenceRoomById(room.getName(), room.getDescription(),
                room.getCapacity(), conferenceRoomId);
        return conferenceRoomRepository.findById(conferenceRoomId)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConferenceRoom> deleteConferenceRoom(@PathVariable(value = "id") Long conferenceId){
        var optionalConferenceRoom = conferenceRoomRepository.findById(conferenceId);
        var conferenceRoomPresent = optionalConferenceRoom.isPresent();
        if ( conferenceRoomPresent ){
            conferenceRoomRepository.deleteById(conferenceId);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.notFound().build();
    }
}
