package com.example.presentation;

import com.example.domain.entity.Employee;
import com.example.domain.service.EmployeeService;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import com.example.presentation.response.AllEmployeesResponse;
import java.net.URI;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 従業員を管理するコントローラークラスです.
 */
@RestController
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  /**
   * ルートURLへのリクエストを処理します.
   *
   * @return 成功メッセージを含むResponseEntity.
   */
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> handleRootRequest() {
    return ResponseEntity.ok("Success! You've accessed the root URL of /v1/employees.");
  }

  /**
   * すべての従業員を返します.
   *
   * @return すべての従業員のリストを含むAllEmployeesResponse.
   */
  @GetMapping("/v1/employees")
  @ResponseStatus(HttpStatus.OK)
  public AllEmployeesResponse findByAllEmployees() {
    return new AllEmployeesResponse(employeeService.findByAllEmployeesOfService());
  }

  /**
   * 従業員をID検索して返します.
   *
   * @param id 検索する従業員のID.
   * @return 従業員が見つかった場合はそのOptionalのEmployee
   */
  @GetMapping("/v1/employees/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<Employee> findByEmployeeId(@PathVariable String id) {
    return employeeService.findByEmployeeIdOfService(id);
  }

  @PostMapping("/v1/employees")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Employee> insertByEmployee(@RequestBody @Validated PostEmployeeRequest postEmployeeRequest) {
    employeeService.insertByEmployeeOfService(postEmployeeRequest);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .pathSegment(postEmployeeRequest.getId())
            .build().encode().toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/v1/employees/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteByEmployee(@PathVariable String id) {
    employeeService.deleteByEmployeeOfService(id);
  }

  @PatchMapping("/v1/employees/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateByEmployee(@PathVariable String id, @RequestBody @Validated UpdateEmployeeRequest updateEmployeeRequest) {
    employeeService.updateByEmployeeOfService(id, updateEmployeeRequest);
  }
}
