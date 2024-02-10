package com.example.presentation;

import com.example.domain.entity.Employee;
import com.example.domain.service.EmployeeService;
import com.example.presentation.response.AllEmployeesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    return new AllEmployeesResponse(employeeService.findByAllEmployeesOfService());
  }

  @GetMapping("/v1/employees/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Employee findByEmployeeId(@PathVariable String id) {
    return employeeService.findByEmployeeIdOfService(id);
  }
}
