package com.example.infrastructure.repository;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.example.presentation.exception.EmployeesNotFoundException;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository の実装クラス.
 */
@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

  private EmployeeMapper employeeMapper;

  @Override
  public List<Employee> findByAllEmployeesOfRepository() {
    return employeeMapper.findAll();
  }

  @Override
  public Employee findByEmployeeOfRepository(String id) {
    if (employeeMapper.findById(id) == null) {
      throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
    }
    return employeeMapper.findById(id);
  }

  @Override
  public void insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest) {
    employeeMapper.insert(postEmployeeRequest);
  }

  @Override
  public void deleteByEmployeeOfRepository(String id) {
    Integer count = employeeMapper.delete(id);
    if (count == 0) {
      throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
    }

    employeeMapper.delete(id);
  }

  @Override
  public void updateByEmployeeOfRepository(String id, UpdateEmployeeRequest updateEmployeeRequest) {
    Integer count = employeeMapper.update(id, updateEmployeeRequest);
    if (count == 0) {
      throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
    }
    employeeMapper.update(id, updateEmployeeRequest);
  }
}
