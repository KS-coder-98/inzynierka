package pl.krzysiek.conferenceroombookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;
import pl.krzysiek.conferenceroombookingsystem.repository.ConferenceRoomRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.EquipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;

    public void deleteById(Long id) {
        Equipment equipmentRepositoryById = equipmentRepository.getById(id);
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findAll();
        for (var con : conferenceRooms) {
            con.getEquipment().remove(equipmentRepositoryById);
        }
        equipmentRepository.deleteById(id);
        conferenceRoomRepository.saveAll(conferenceRooms);
    }

}
