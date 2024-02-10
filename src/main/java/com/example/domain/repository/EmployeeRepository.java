package com.example.domain.repository;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import java.util.List;

/**
 * employees テーブルにアクセスするためのリポジトリ.
 */
public interface EmployeeRepository {
  List<Employee> findByAllEmployeesOfRepository();

  Employee findByEmployeeOfRepository(String id);

  PostEmployeeRequest insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest);
}
