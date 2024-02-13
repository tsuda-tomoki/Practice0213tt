package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.EmployeeService;
import com.example.domain.request.PostEmployeeRequest;
import com.example.domain.request.UpdateEmployeeRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 従業員関連のビジネスロジックを実装するサービスクラス.
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = true)
  public List<Employee> findByAllEmployeesOfService() {
    return employeeRepository.findByAllEmployeesOfRepository();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = true)
  public Employee findByEmployeeIdOfService(String id) {
    return employeeRepository.findByEmployeeOfRepository(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest) {
    employeeRepository.insertByEmployeeOfRepositroy(postEmployeeRequest);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void deleteByEmployeeOfService(String id) {
    employeeRepository.deleteByEmployeeOfRepository(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void updateByEmployeeOfService(String id, UpdateEmployeeRequest updateEmployeeRequest) {
    employeeRepository.updateByEmployeeOfRepository(id, updateEmployeeRequest);
  }
}
