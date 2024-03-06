package com.coherent.hotel.service;

import com.coherent.hotel.model.Reservation;

import java.util.Set;

public interface ReservationService {

    Reservation createReservation(Reservation input);

    Set<Reservation> readAllReservations();

    Reservation updateReservation(Integer reservationId, Reservation updateReservation);
}
