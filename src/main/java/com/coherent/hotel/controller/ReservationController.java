package com.coherent.hotel.controller;

import com.coherent.hotel.dto.ReservationDto;
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
    public ReservationDto createReservation(@RequestBody ReservationDto input) {
        log.traceEntry("Create a new reservation: {}", input);
        return log.traceExit(reservationService.createReservation(input));
    }

    @GetMapping()
    public Set<ReservationDto> readAllReservations() {
        log.traceEntry("Read all reservations");
        log.traceExit();
        return reservationService.readAllReservations();
    }

    @PatchMapping("/{reservationId}")
    public ReservationDto updateReservation(@PathVariable("reservationId") Integer reservationId,
                                         @RequestBody ReservationDto updateReservation) {
        log.traceEntry("Update reservation with id: {}, {}", reservationId, updateReservation);
        return log.traceExit(reservationService.updateReservation(reservationId, updateReservation));
    }
}
