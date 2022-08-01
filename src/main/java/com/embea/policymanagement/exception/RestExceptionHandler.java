package com.embea.policymanagement.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(
      value = {
        PolicyNotFoundException.class,
      })
  protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {

    ApiError error = ApiError.builder().message(ex.getMessage()).build();
    return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    ApiError error = ApiError.builder().message(ex.getFieldError().getDefaultMessage()).build();
    return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
