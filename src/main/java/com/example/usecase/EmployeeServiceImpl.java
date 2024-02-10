package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
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
