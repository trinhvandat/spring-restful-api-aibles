package org.aibles.backendjava.carservice.exception.common;

public enum CarServiceError {

    CAR_NOT_FOUND(404, "Car not found"),
    TEACHER_NOT_FOUND(404, "Teacher not found");

    private CarServiceError(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private final int errorCode;
    private final String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
