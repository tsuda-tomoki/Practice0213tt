package com.example.presentation;

import com.example.presentation.exception.EmployeesNotFoundException;
import com.example.presentation.response.Details;
import com.example.presentation.response.ExceptionHandResponse;
import com.example.presentation.response.ExceptionResponse;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * コントローラークラスの例外ハンドリングクラス.
 */
@RestControllerAdvice
public class ExceptionsController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleError(
      MethodArgumentNotValidException methodArgumentNotValidException) {
    List<Details> detailsList = List.of(new Details("firstName must not be blank"));
    return new ExceptionResponse("0002", "request validation error is occurred.", detailsList);
  }

  @ExceptionHandler(EmployeesNotFoundException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionHandResponse handleEmployeeNotFound(EmployeesNotFoundException e) {
    String message = e.getMessage();
    return new ExceptionHandResponse("0003", message, Collections.emptyList());
  }
}
