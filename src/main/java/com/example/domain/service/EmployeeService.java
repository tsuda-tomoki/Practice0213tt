package com.example.domain.service;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;
import java.util.Optional;

/**
 * サービスクラスのインターフェイス.
 */
public interface EmployeeService {
  List<Employee> findByAllEmployeesOfService();

  Optional<Employee> findByEmployeeIdOfService(String id);

  void insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest);

  void deleteByEmployeeOfService(String id);

  void updateByEmployeeOfService(String id, UpdateEmployeeRequest updateEmployeeRequest);

}
