package pl.krzysiek.conferenceroombookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
