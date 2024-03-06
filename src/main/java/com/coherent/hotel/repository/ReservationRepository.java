package com.coherent.hotel.repository;

import com.coherent.hotel.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ReservationRepository {

    private static Set<Reservation> reservations = new HashSet<>();

    public Reservation createReservation(Reservation input) {
        return null;
    }

    public Set<Reservation> findAllReservations() {
        return reservations;
    }

    public Reservation updateReservation(Integer reservationId, Reservation updateReservation) {
        return null;
    }
}
