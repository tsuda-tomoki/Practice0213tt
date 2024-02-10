package com.example.presentation;

import com.example.domain.service.EmployeeService;
import com.example.presentation.response.AllEmployeesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * employee のコントローラークラス.
 */
@RestController
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  @GetMapping("/v1/employees")
  @ResponseStatus(HttpStatus.OK)
  public AllEmployeesResponse findByAllEmployees() {
    System.out.println(employeeService.findByAllEmployeesOfService());
    return new AllEmployeesResponse(employeeService.findByAllEmployeesOfService());
  }
}
