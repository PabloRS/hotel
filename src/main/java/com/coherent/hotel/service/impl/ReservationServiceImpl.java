package com.coherent.hotel.service.impl;

import com.coherent.hotel.dto.ReservationDto;
import com.coherent.hotel.mapper.ReservationMapper;
import com.coherent.hotel.model.Reservation;
import com.coherent.hotel.repository.ReservationRepository;
import com.coherent.hotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;

    @Override
    public ReservationDto createReservation(ReservationDto input) {
        log.debug("Create new reservation for client: {}", input.getClientFullName());
        Reservation reservation = mapper.toModel(input);
        return log.traceExit(mapper.toDto(repository.createReservation(reservation)));
    }

    @Override
    public Set<ReservationDto> readAllReservations() {
        log.traceEntry("Read all reservations");
        Set<Reservation> reservations = repository.findAllReservations();
        log.traceExit();
        return reservations
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public ReservationDto updateReservation(Integer reservationId, ReservationDto updateReservation) {
        log.traceEntry("Update reservation with id: {}", reservationId);
        Reservation toUpdate = mapper.toModel(updateReservation);
        ReservationDto updated = mapper.toDto(repository.updateReservation(reservationId, toUpdate));
        return log.traceExit(updated);
    }
}
