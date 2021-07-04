package org.aibles.backendjava.carservice.exception.common;

public abstract class CarServiceException extends RuntimeException{

    private final CarServiceError carServiceError;

    private static final long serialVersionUID = 1L;

    protected CarServiceException(CarServiceError carServiceError){
        super();
        this.carServiceError = carServiceError;
    }

    public CarServiceError getCarServiceError() {
        return carServiceError;
    }
}
