package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.dto.ConferenceRoomDto;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;
import pl.krzysiek.conferenceroombookingsystem.mapper.ConferenceRoomMapper;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.EquipmentRepository;

import java.util.Optional;

@RestController
@RequestMapping("conference-room")
@RequiredArgsConstructor
public class ConferenceRoomController {


    private final ConferenceRoomRepository conferenceRoomRepository;
    private final EquipmentRepository equipmentRepository;
    private final ConferenceRoomMapper conferenceRoomMapper;


    @GetMapping("{id}")
    public ResponseEntity<ConferenceRoomDto> one(@PathVariable Long id) {
        return conferenceRoomRepository.findById(id)
                .map(conferenceRoomMapper::toConferenceRoomDto)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<ConferenceRoomDto>> all(Pageable pageable) {
        var page = conferenceRoomRepository.findAll(pageable);
        return ResponseEntity.ok().body(page.map(conferenceRoomMapper::toConferenceRoomDto));
    }

    @GetMapping("/create")
    public ResponseEntity<ConferenceRoom> create(@RequestBody ConferenceRoom conferenceRoom) {
        ConferenceRoom conferenceRoom1 = conferenceRoomRepository.save(conferenceRoom);
        return new ResponseEntity<>(conferenceRoom1, HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<ConferenceRoomDto> updateConferenceRoom(@RequestBody ConferenceRoom room) {
        conferenceRoomRepository.setConferenceRoomById(room.getName(), room.getDescription(),
                room.getCapacity(), room.getId());
        return conferenceRoomRepository.findById(room.getId())
                .map(conferenceRoomMapper::toConferenceRoomDto)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ConferenceRoomDto> deleteConferenceRoom(@PathVariable(value = "id") Long conferenceId) {
        var optionalConferenceRoom = conferenceRoomRepository.findById(conferenceId);
        var conferenceRoomPresent = optionalConferenceRoom.isPresent();
        if (conferenceRoomPresent) {
            conferenceRoomRepository.deleteById(conferenceId);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/add-eq-to-cr")
    public ResponseEntity<ConferenceRoomDto> addEquipmentToConferenceRoom(@RequestParam Long conferenceRoomId, @RequestParam Long equipmentId) {
        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(conferenceRoomId);
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        if (optionalEquipment.isEmpty() || optionalConferenceRoom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ConferenceRoom conferenceRoom = optionalConferenceRoom.get();
        Equipment equipment = optionalEquipment.get();
        conferenceRoom.getEquipment().add(equipment);
        conferenceRoomRepository.save(conferenceRoom);
        return ResponseEntity.ok().body(conferenceRoomMapper.toConferenceRoomDto(conferenceRoom));
    }
}
