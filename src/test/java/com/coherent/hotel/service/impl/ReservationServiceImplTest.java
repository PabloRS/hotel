package com.coherent.hotel.service.impl;

import com.coherent.hotel.dto.ReservationDto;
import com.coherent.hotel.exception.ReservationException;
import com.coherent.hotel.mapper.ReservationMapper;
import com.coherent.hotel.repository.ReservationRepository;
import com.coherent.hotel.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationServiceImplTest {

    @InjectMocks
    private ReservationMapper mapper = ReservationMapper.INSTANCE;

    private ReservationRepository repository;

    private ReservationServiceImpl service;

    @BeforeEach
    public void init() {
        repository = new ReservationRepository();
        service = new ReservationServiceImpl(repository, mapper);
    }

    @Test
    public void createReservationTest() {
        ReservationDto result = service.createReservation(TestUtils.createReservationDto());
        assertNotNull(result);
        assertTrue(result.getReservationDates().size() == 2);
        assertEquals("Test user", result.getClientFullName());
    }

    @Test
    public void readAllReservations() {
        service.createReservation(TestUtils.createReservationDto());
        service.createReservation(TestUtils.createReservationDto());
        Set<ReservationDto> result = service.readAllReservations();
        assertTrue(!result.isEmpty());
    }

    @Test
    public void updateReservation() {
        service.createReservation(TestUtils.createReservationDto());
        ReservationDto result = service.updateReservation(1, TestUtils.updateReservationDto());
        assertNotNull(result);
        assertEquals(124, result.getRoomNumber());
        assertEquals("Test user updated", result.getClientFullName());
    }

    @Test
    public void updateReservationExceptionTest() {
        ReservationException ex = assertThrows(ReservationException.class, () ->
                service.updateReservation(12, TestUtils.updateReservationDto()), "Reservation could not be updated");

        assertTrue(ex.getMessage().contains("Reservation could not be updated"));

    }

}
