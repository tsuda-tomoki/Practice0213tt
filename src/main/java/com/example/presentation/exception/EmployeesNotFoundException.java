package com.example.presentation.exception;

public class EmployeesNotFoundException extends RuntimeException {

  public EmployeesNotFoundException(String message) {
    super(message);
  }
}
