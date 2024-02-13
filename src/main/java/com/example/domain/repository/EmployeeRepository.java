package com.example.domain.repository;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;

/**
 * employees テーブルにアクセスするためのリポジトリ.
 */
public interface EmployeeRepository {
  List<Employee> findByAllEmployeesOfRepository();

  Employee findByEmployeeOfRepository(String id);

  void insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest);

  void deleteByEmployeeOfRepository(String id);

  void updateByEmployeeOfRepository(String id, UpdateEmployeeRequest updateEmployeeRequest);
}
