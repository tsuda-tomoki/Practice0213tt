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
 * コントローラークラスの例外ハンドリングを行うクラスです.
 */
@RestControllerAdvice
public class ExceptionsController {

  /**
   * メソッド引数が無効な場合の例外ハンドリングを行います.
   *
   * @param methodArgumentNotValidException 発生したMethodArgumentNotValidException
   * @return 例外レスポンス
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleError(
      MethodArgumentNotValidException methodArgumentNotValidException) {
    List<String> detailsList = List.of("firstName must not be blank");
    return new ExceptionResponse("0002", "request validation error is occurred.", detailsList);
  }

  /**
   * 従業員が見つからない場合の例外ハンドリングを行います.
   *
   * @param e 発生したEmployeesNotFoundException
   * @return 例外レスポンス
   */
  @ExceptionHandler(EmployeesNotFoundException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionHandResponse handleEmployeeNotFound(EmployeesNotFoundException e) {
    String message = e.getMessage();
    return new ExceptionHandResponse("0003", message, Collections.emptyList());
  }
}
