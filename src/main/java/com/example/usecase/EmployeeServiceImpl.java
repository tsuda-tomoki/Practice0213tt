package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.EmployeeService;
import com.example.presentation.request.PostEmployeeRequest;
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

  @Override
  @Transactional(readOnly = true)
  public Employee findByEmployeeIdOfService(String id) {
    return employeeRepository.findByEmployeeOfRepository(id);
  }

  @Override
  @Transactional
  public PostEmployeeRequest insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest) {
    return employeeRepository.insertByEmployeeOfRepositroy(postEmployeeRequest);
  }

}
