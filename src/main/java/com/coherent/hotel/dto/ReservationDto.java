package com.coherent.hotel.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReservationDto {

    Integer id;
    String clientFullName;
    Integer roomNumber;
    List<LocalDate> reservationDates;

}
