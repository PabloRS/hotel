package com.coherent.hotel.service.impl;

import com.coherent.hotel.model.Reservation;
import com.coherent.hotel.repository.ReservationRepository;
import com.coherent.hotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public Reservation createReservation(Reservation input) {
        return null;
    }

    @Override
    public Set<Reservation> readAllReservations() {
        log.traceEntry("Read all reservations");
        repository.findAllReservations();
        return null;
    }

    @Override
    public Reservation updateReservation(Integer reservationId, Reservation updateReservation) {
        return null;
    }
}
