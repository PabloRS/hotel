package com.coherent.hotel.utils;

import com.coherent.hotel.dto.ReservationDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static ReservationDto createReservationDto() {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setRoomNumber(123);
        reservationDto.setClientFullName("Test user");
        reservationDto.setReservationDates(createDates());
        return reservationDto;
    }

    public static ReservationDto updateReservationDto() {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setRoomNumber(124);
        reservationDto.setClientFullName("Test user updated");
        reservationDto.setReservationDates(createDates());
        return reservationDto;
    }

    private static List<LocalDate> createDates() {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2024, 4, 24));
        dates.add(LocalDate.of(2024, 4, 22));
        return dates;
    }
}
