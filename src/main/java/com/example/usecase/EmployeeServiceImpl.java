package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.service.EmployeeService;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.example.presentation.exception.EmployeesNotFoundException;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
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
  private EmployeeMapper employeeMapper;

  @Override
  @Transactional(readOnly = true)
  public List<Employee> findByAllEmployeesOfService() {
    return employeeMapper.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Employee findByEmployeeIdOfService(String id) {
    if (employeeMapper.findById(id) == null) {
      throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
    }
    return employeeMapper.findById(id);
  }

  @Override
  @Transactional
  public void insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest) {
    employeeMapper.insert(postEmployeeRequest);
  }

  @Override
  @Transactional
  public void deleteByEmployeeOfService(String id) {
    Integer count = employeeMapper.delete(id);
    if (count == 0) {
      throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
    }
    employeeMapper.delete(id);
  }

  @Override
  @Transactional
  public void updateByEmployeeOfService(String id, UpdateEmployeeRequest updateEmployeeRequest) {
    Integer count = employeeMapper.update(id, updateEmployeeRequest);
    if (count == 0) {
      throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
    }
    employeeMapper.update(id, updateEmployeeRequest);
  }
}
