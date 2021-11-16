package pl.krzysiek.conferenceroombookingsystem.mapper;

import org.mapstruct.Mapper;
import pl.krzysiek.conferenceroombookingsystem.dto.ReservationDto;
import pl.krzysiek.conferenceroombookingsystem.entity.Reservation;

@Mapper
public interface ReservationMapper {
    ReservationDto toReservationDto(Reservation reservation);
}
