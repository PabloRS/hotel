package com.coherent.hotel.exception;


import org.springframework.http.HttpStatus;

public class ReservationException extends RuntimeException{

    private HttpStatus httpStatus;
    public ReservationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
