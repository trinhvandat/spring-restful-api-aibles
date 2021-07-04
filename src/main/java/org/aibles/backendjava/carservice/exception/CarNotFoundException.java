package org.aibles.backendjava.carservice.exception;

import org.aibles.backendjava.carservice.exception.common.CarServiceError;
import org.aibles.backendjava.carservice.exception.common.CarServiceException;

public class CarNotFoundException extends CarServiceException {
    public CarNotFoundException() {
        super(CarServiceError.CAR_NOT_FOUND);
    }
}
