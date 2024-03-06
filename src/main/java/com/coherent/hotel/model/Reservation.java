package com.coherent.hotel.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Reservation {
    Integer id;
    String clientFullName;
    Integer roomNumber;
    List<LocalDate> reservationDates;
}
