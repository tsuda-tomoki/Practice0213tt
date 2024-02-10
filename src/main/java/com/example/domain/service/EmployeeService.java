package com.example.domain.service;

import com.example.domain.entity.Employee;
import java.util.List;

/**
 * サービスクラスのインターフェイス.
 */
public interface EmployeeService {
  List<Employee> findByAllEmployeesOfService();

  Employee findByEmployeeIdOfService(String id);

  Employee insertByEmployeeOfService(Employee employee);

}
