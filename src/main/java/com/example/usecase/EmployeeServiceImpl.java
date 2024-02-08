package com.example.usecase;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import com.example.domain.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * employeeService の実装クラス.
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Employee> findByAllEmployeesOfService() {
    return employeeRepository.findByAllEmployeesOfRepository();
  }
}
