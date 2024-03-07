package com.coherent.hotel.service;

import com.coherent.hotel.dto.ReservationDto;

import java.util.Set;

public interface ReservationService {

    ReservationDto createReservation(ReservationDto input);

    Set<ReservationDto> readAllReservations();

    ReservationDto updateReservation(Integer reservationId, ReservationDto updateReservation);
}
