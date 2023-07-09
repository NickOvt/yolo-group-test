package org.yolotest.test.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

//@ControllerAdvice
//public class ValidationHandler extends ResponseEntityExceptionHandler {
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        List<List<String>> errors = new ArrayList<>();
//
//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            String erroredObjectFieldName = ((FieldError) error).getField();
//            String erroredObjectErrorMessage = error.getDefaultMessage();
//
//            if (erroredObjectErrorMessage == null) {
//                erroredObjectErrorMessage = "There was an unexpected error";
//            }
//
//            errors.add(List.of(erroredObjectFieldName, erroredObjectErrorMessage));
//        });
//
////        List<DtoFieldValidationError> dtoFieldValidationErrors = errors.stream().map(el -> new DtoFieldValidationError(el.get(0), el.get(1))).toList();
////        DtoValidationErrorMessage dtoValidationErrorMessage = new DtoValidationErrorMessage("There is an error with the data provided", dtoFieldValidationErrors);
////        return new ResponseEntity<>(dtoValidationErrorMessage, HttpStatus.PRECONDITION_FAILED);
//
//          return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);

//    }
//}
