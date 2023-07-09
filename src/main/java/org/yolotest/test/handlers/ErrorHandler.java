package org.yolotest.test.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.yolotest.test.dtos.errors.ErrorResponse;
import org.yolotest.test.exceptions.ApplicationException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<List<String>> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String erroredObjectFieldName = ((FieldError) error).getField();
            String erroredObjectErrorMessage = error.getDefaultMessage();

            if (erroredObjectErrorMessage == null) {
                erroredObjectErrorMessage = "There was an unexpected error";
            }

            errors.add(List.of(erroredObjectFieldName, erroredObjectErrorMessage));
        });

//        List<DtoFieldValidationError> dtoFieldValidationErrors = errors.stream().map(el -> new DtoFieldValidationError(el.get(0), el.get(1))).toList();
//        DtoValidationErrorMessage dtoValidationErrorMessage = new DtoValidationErrorMessage("There is an error with the data provided", dtoFieldValidationErrors);
//        return new ResponseEntity<>(dtoValidationErrorMessage, HttpStatus.PRECONDITION_FAILED);

        return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);
    }
}
