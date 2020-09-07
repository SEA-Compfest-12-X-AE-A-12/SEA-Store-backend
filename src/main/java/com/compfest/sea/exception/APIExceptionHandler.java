package com.compfest.sea.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class APIExceptionHandler {
  @ExceptionHandler(value = {ResourceNotFoundException.class})
  public ResponseEntity<Object> handleResourceNotFound(
      ResourceNotFoundException ex, WebRequest request) {
    ErrorDetails details =
        new ErrorDetails(new Date(), ex.getMessage() + " not found", request.getDescription(false));
    return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {ResourceAlreadyExistException.class})
  public ResponseEntity<Object> handleResourceAlreadyExist(
      ResourceAlreadyExistException ex, WebRequest request) {
    ErrorDetails details =
        new ErrorDetails(
            new Date(), ex.getMessage() + " already exist", request.getDescription(false));
    return new ResponseEntity<>(details, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = {NotAuthorizedException.class})
  public ResponseEntity<Object> handleNotAuthorized(NotAuthorizedException ex, WebRequest request) {
    ErrorDetails details =
        new ErrorDetails(new Date(), "user not authorized", request.getDescription(false));
    return new ResponseEntity<>(details, HttpStatus.CONFLICT);
  }
}
