package com.coherent.hotel.repository;

import com.coherent.hotel.exception.ReservationException;
import com.coherent.hotel.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * This class will simulate a repository since there is no requirement to connect to a database.
 * In a real scenario, it would be an interface and marked as repository.
 * Methods would be abstract and use a JPA library.
 */
@RequiredArgsConstructor
@Service
public class ReservationRepository {

    private static Set<Reservation> reservations = new HashSet<>();

    /**
     * This function will simulate an auto-increment index in a database.
     * @param input
     * @return Reservation created
     */
    public Reservation createReservation(Reservation input) {
        Integer id = reservations.size() + 1;
        input.setId(id);
        boolean added = reservations.add(input);
        if (added) {
            return input;
        }
        throw new ReservationException("Reservation could not be created", HttpStatus.BAD_REQUEST);
    }

    public Set<Reservation> findAllReservations() {
        if (reservations.isEmpty()) {
            throw new ReservationException("No reservations exist on database", HttpStatus.NO_CONTENT);
        }
        return reservations;
    }

    /**
     * A database could handle by itself a patch operation, the intention with this function is simulate that.
     * @param reservationId reservation id to update
     * @param updateReservation values of a reservation to be updated
     * @return an updated reservation
     */
    public Reservation updateReservation(Integer reservationId, Reservation updateReservation) {
        updateReservation.setId(reservationId);
        Reservation toDelete = null;
        for (Reservation reservation: reservations) {
            if (reservation.getId() == reservationId) {
                toDelete = reservation;
            }
        }
        if (Objects.nonNull(toDelete)) {
            reservations.remove(toDelete);
            updateNullValues(toDelete, updateReservation);
            reservations.add(updateReservation);
            return updateReservation;
        }
        throw new ReservationException("Reservation could not be updated", HttpStatus.BAD_REQUEST);
    }

    private void updateNullValues(Reservation toDelete, Reservation toUpdate) {
        toUpdate.setClientFullName(Objects.isNull(toUpdate.getClientFullName()) ? toDelete.getClientFullName() : toUpdate.getClientFullName());
        toUpdate.setRoomNumber(Objects.isNull(toUpdate.getRoomNumber()) ? toDelete.getRoomNumber() : toUpdate.getRoomNumber());
        toUpdate.setReservationDates(Objects.isNull(toUpdate.getReservationDates()) ? toDelete.getReservationDates() : toUpdate.getReservationDates());
    }
}
