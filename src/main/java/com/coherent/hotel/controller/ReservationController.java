package com.coherent.hotel.controller;

import com.coherent.hotel.model.Reservation;
import com.coherent.hotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/rest-api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping()
    public Reservation createReservation(@RequestBody Reservation input) {
        log.traceEntry("Save a new reservation: {}", input);
        reservationService.createReservation(input);
        return null;
    }

    @GetMapping()
    public Set<Reservation> readAllReservations() {
        log.traceEntry("Read all reservations");
        return reservationService.readAllReservations();
    }

    @PatchMapping("/{reservationId}")
    public Reservation updateReservation(@PathVariable("reservationId") Integer reservationId,
                                         @RequestBody Reservation updateReservation) {
        log.traceEntry("Update reservation with id: {}", reservationId);
        reservationService.updateReservation(reservationId, updateReservation);
        return null;
    }
}
