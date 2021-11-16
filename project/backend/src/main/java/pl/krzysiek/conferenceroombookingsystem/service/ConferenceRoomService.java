package pl.krzysiek.conferenceroombookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.krzysiek.conferenceroombookingsystem.dto.ConferenceRoomDto;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;
import pl.krzysiek.conferenceroombookingsystem.mapper.ConferenceRoomMapper;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.EquipmentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConferenceRoomService {

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final EquipmentRepository equipmentRepository;
    private final ConferenceRoomMapper conferenceRoomMapper;

    public Optional<ConferenceRoomDto> getConferenceRoomById(Long id) {
        return conferenceRoomRepository.findById(id)
                .map(conferenceRoomMapper::toConferenceRoomDto);
    }

    public Page<ConferenceRoomDto> getAllConferenceRooms(Pageable pageable) {
        return conferenceRoomRepository.findAll(pageable)
                .map(conferenceRoomMapper::toConferenceRoomDto);
    }

    public ConferenceRoomDto create(ConferenceRoom conferenceRoom) {
        return conferenceRoomMapper.toConferenceRoomDto(conferenceRoomRepository.save(conferenceRoom));
    }

    public Optional<ConferenceRoomDto> update(ConferenceRoom room) {
        conferenceRoomRepository.setConferenceRoomById(room.getName(), room.getDescription(),
                room.getCapacity(), room.getId());
        return conferenceRoomRepository.findById(room.getId())
                .map(conferenceRoomMapper::toConferenceRoomDto);
    }

    public Boolean delete(Long id) {
        var optionalConferenceRoom = conferenceRoomRepository.findById(id);
        var conferenceRoomPresent = optionalConferenceRoom.isPresent();
        if (conferenceRoomPresent) {
            conferenceRoomRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<ConferenceRoomDto> addEquipment(@RequestParam Long conferenceRoomId, @RequestParam Long equipmentId) {
        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(conferenceRoomId);
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        if (optionalEquipment.isEmpty() || optionalConferenceRoom.isEmpty()) {
            return Optional.empty();
        }
        ConferenceRoom conferenceRoom = optionalConferenceRoom.get();
        Equipment equipment = optionalEquipment.get();
        conferenceRoom.getEquipment().add(equipment);
        var res = conferenceRoomRepository.save(conferenceRoom);
        return Optional.of(conferenceRoomMapper.toConferenceRoomDto(res));
    }
}
