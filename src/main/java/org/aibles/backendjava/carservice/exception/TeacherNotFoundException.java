package org.aibles.backendjava.carservice.exception;

import org.aibles.backendjava.carservice.exception.common.CarServiceError;
import org.aibles.backendjava.carservice.exception.common.CarServiceException;

public class TeacherNotFoundException extends CarServiceException {
    public TeacherNotFoundException() {
        super(CarServiceError.TEACHER_NOT_FOUND);
    }
}
