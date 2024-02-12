package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.EmployeeService;
import com.example.presentation.exception.EmployeesNotFoundException;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;
import java.util.Optional;
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
  public void insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest) {
    employeeRepository.insertByEmployeeOfRepositroy(postEmployeeRequest);
  }

  @Override
  @Transactional
  public void deleteByEmployeeOfService(String id) {
    employeeRepository.deleteByEmployeeOfRepository(id);
  }

  @Override
  @Transactional
  public void updateByEmployeeOfService(String id, UpdateEmployeeRequest updateEmployeeRequest) {
    employeeRepository.updateByEmployeeOfRepository(id, updateEmployeeRequest);
  }
}
