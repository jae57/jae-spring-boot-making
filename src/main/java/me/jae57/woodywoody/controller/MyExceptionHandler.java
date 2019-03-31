package me.jae57.woodywoody.controller;

import me.jae57.woodywoody.exception.DuplicateScentIdException;
import me.jae57.woodywoody.exception.EmptyDataException;
import me.jae57.woodywoody.exception.FamilyNotFoundException;
import me.jae57.woodywoody.exception.ScentNotFoundException;
import me.jae57.woodywoody.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({ScentNotFoundException.class, FamilyNotFoundException.class, EmptyDataException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity notFound(RuntimeException re){
        ErrorDetail errorDetail= new ErrorDetail();
        errorDetail.setTimeStamp(new Date());
        errorDetail.setCode(1002);
        errorDetail.setMessage(re.getMessage());
        return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateScentIdException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity duplicate(RuntimeException re){
        ErrorDetail errorDetail= new ErrorDetail();
        errorDetail.setTimeStamp(new Date());
        errorDetail.setCode(1002);
        errorDetail.setMessage(re.getMessage());
        return new ResponseEntity(errorDetail, HttpStatus.CONFLICT);
    }
}
