package com.example.domain.service;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import java.util.List;

/**
 * サービスクラスのインターフェイス.
 */
public interface EmployeeService {
  List<Employee> findByAllEmployeesOfService();

  Employee findByEmployeeIdOfService(String id);

  PostEmployeeRequest insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest);

  void deleteByEmployeeOfService(String id);

}
