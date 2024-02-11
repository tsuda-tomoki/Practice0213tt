package com.example.infrastructure.repository;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.example.presentation.request.PostEmployeeRequest;
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
    return employeeMapper.findById(id);
  }

  @Override
  public PostEmployeeRequest insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest) {
    return postEmployeeRequest;
  }

  @Override
  public void deleteByEmployeeOfRepository(String id) {
    employeeMapper.delete(id);
  }
}
