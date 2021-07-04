package org.aibles.backendjava.carservice.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.aibles.backendjava.carservice.exception.common.CarServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CarControllerAdvice {

    @ExceptionHandler(value = CarServiceException.class)
    public ResponseEntity<String> CarServiceExceptionHandle(CarServiceException e){
        return new ResponseEntity<>(
                e.getCarServiceError().getErrorMessage(),
                HttpStatus.valueOf(e.getCarServiceError().getErrorCode())
        );
    }
}
