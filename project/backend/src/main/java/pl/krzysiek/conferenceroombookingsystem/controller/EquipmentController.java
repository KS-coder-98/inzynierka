package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;
import pl.krzysiek.conferenceroombookingsystem.repository.EquipmentRepository;

import java.util.Optional;

@RestController
@RequestMapping("equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> one(@PathVariable Long id) {
        return equipmentRepository.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<Equipment>> all(Pageable pageable) {
        var page = equipmentRepository.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<Equipment> create(@RequestBody Equipment equipment) {
        Equipment equipment1 = equipmentRepository.save(equipment);
        return new ResponseEntity<>(equipment1, HttpStatus.CREATED);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Equipment> deleteEquipment(@PathVariable Long id) {
        var optionalEquipment = equipmentRepository.findById(id);
        var equipmentPresent = optionalEquipment.isPresent();
        if (equipmentPresent) {
            equipmentRepository.deleteById(id);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Equipment> update(@RequestBody Equipment equipment) {
        Optional<Equipment> byId = equipmentRepository.findById(equipment.getId());
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Equipment equipment1 = byId.get();
        equipment1.setName(equipment.getName());
        equipment1.setDescription(equipment.getDescription());
        var result = equipmentRepository.save(equipment1);
        return ResponseEntity.ok().body(result);

    }
}
