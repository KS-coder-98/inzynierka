package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.dto.EquipmentDto;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;
import pl.krzysiek.conferenceroombookingsystem.mapper.EquipmentMapper;
import pl.krzysiek.conferenceroombookingsystem.repository.EquipmentRepository;
import pl.krzysiek.conferenceroombookingsystem.service.EquipmentService;

import java.util.Optional;

@RestController
@RequestMapping("equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;
    private final EquipmentService equipmentService;

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDto> one(@PathVariable Long id) {
        return equipmentRepository.findById(id)
                .map(equipmentMapper::toEquipmentDto)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<EquipmentDto>> all(Pageable pageable) {
        var page = equipmentRepository.findAll(pageable);
        return ResponseEntity.ok().body(page.map(equipmentMapper::toEquipmentDto));
    }

    @GetMapping("/create")
    public ResponseEntity<EquipmentDto> create(@RequestBody Equipment equipment) {
        Equipment equipment1 = equipmentRepository.save(equipment);
        return new ResponseEntity<>(equipmentMapper.toEquipmentDto(equipment1), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EquipmentDto> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<EquipmentDto> update(@RequestBody Equipment equipment) {
        Optional<Equipment> byId = equipmentRepository.findById(equipment.getId());
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Equipment equipment1 = byId.get();
        equipment1.setName(equipment.getName());
        equipment1.setDescription(equipment.getDescription());
        var result = equipmentRepository.save(equipment1);
        return ResponseEntity.ok().body(equipmentMapper.toEquipmentDto(result));

    }
}
