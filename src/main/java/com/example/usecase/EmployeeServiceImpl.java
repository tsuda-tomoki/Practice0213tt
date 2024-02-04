package com.example.usecase;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import com.example.domain.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * employeeService の実装クラス.
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;

  @Transactional(readOnly = true)
  public List<Employee> findByAllEmployees() {
    return employeeRepository.findByAllEmployeesOfRepository();
  }
}
