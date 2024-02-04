package com.example.infrastructure;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository の実装クラス.
 */
@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
  private EmployeeMapper employeeMapper;

  @Override
  public List<Employee> findByAllEmployees() {
    return employeeMapper.findAll();
  }
}
