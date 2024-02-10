package com.example.presentation;

import com.example.presentation.response.DetailResponse;
import com.example.presentation.response.ExceptionResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionsController {
  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleError(
      MethodArgumentNotValidException methodArgumentNotValidException) {
    List<DetailResponse> detailsList = List.of(new DetailResponse("firstName must not be blank"));
    return new ExceptionResponse("0002", "request validation error is occurred.", detailsList);
  }
}
