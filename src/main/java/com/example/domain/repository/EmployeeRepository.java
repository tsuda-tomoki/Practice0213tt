package com.example.domain.repository;

import com.example.domain.entity.Employee;
import java.util.List;

/**
 * employees テーブルにアクセスするためのリポジトリ.
 */
public interface EmployeeRepository {
  List<Employee> findByAllEmployeesOfRepository();

  Employee findByEmployeeOfRepository(String id);

  Employee insertByEmployeeOfRepositroy(Employee employee);
}
