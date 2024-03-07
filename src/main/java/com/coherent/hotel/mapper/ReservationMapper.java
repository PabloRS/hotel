package com.coherent.hotel.mapper;

import com.coherent.hotel.dto.ReservationDto;
import com.coherent.hotel.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationDto toDto(Reservation reservation);

    Reservation toModel(ReservationDto reservationDto);

}
