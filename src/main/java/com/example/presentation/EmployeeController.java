package com.example.presentation;

import com.example.domain.entity.Employee;
import com.example.domain.service.EmployeeService;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.response.AllEmployeesResponse;
import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @PostMapping("/v1/employees")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Employee> insertByEmployee(@RequestBody @Validated PostEmployeeRequest postEmployeeRequest) {
    employeeService.insertByEmployeeOfService(postEmployeeRequest);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .pathSegment(postEmployeeRequest.id())
            .build().encode().toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/v1/employees/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteByEmployee(@PathVariable String id) {
    employeeService.deleteByEmployeeOfService(id);
  }
}
