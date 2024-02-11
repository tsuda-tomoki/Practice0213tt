package com.example.domain.repository;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import java.util.List;
import java.util.Optional;

/**
 * employees テーブルにアクセスするためのリポジトリ.
 */
public interface EmployeeRepository {
  List<Employee> findByAllEmployeesOfRepository();

  Optional<Employee> findByEmployeeOfRepository(String id);

  PostEmployeeRequest insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest);

  void deleteByEmployeeOfRepository(String id);
}
