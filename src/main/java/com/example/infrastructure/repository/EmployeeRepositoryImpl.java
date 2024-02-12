package com.example.infrastructure.repository;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;
import java.util.Optional;
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
  public Optional<Employee> findByEmployeeOfRepository(String id) {
    return Optional.of(employeeMapper.findById(id));
  }

  @Override
  public void insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest) {
    employeeMapper.insert(postEmployeeRequest);
  }

  @Override
  public void deleteByEmployeeOfRepository(String id) {
    employeeMapper.delete(id);
  }

  @Override
  public void updateByEmployeeOfRepository(String id, UpdateEmployeeRequest updateEmployeeRequest) {
    employeeMapper.update(id, updateEmployeeRequest);
  }
}
