package pl.krzysiek.conferenceroombookingsystem.mapper;

import org.mapstruct.Mapper;
import pl.krzysiek.conferenceroombookingsystem.dto.EquipmentDto;
import pl.krzysiek.conferenceroombookingsystem.entity.Equipment;

@Mapper
public interface EquipmentMapper {
    EquipmentDto toEquipmentDto(Equipment equipment);
}
