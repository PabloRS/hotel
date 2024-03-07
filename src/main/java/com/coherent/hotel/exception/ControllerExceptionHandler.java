package com.coherent.hotel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<String> handleException(ReservationException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }
}


