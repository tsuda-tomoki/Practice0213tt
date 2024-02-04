package com.example.infrastructure;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeRepositoryImplTest {

  @Mock
  private EmployeeMapper employeeMapper;

  @InjectMocks
  private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void 全件検索ができる場合() {
    // setup
    List<Employee> expected = List.of(
        new Employee("1", "Taro", "Yamada"),
        new Employee("2", "Jiro", "Yamada")
    );

    when(employeeMapper.findAll()).thenReturn(expected);

    // execute
    List<Employee> actual = employeeRepository.findByAllEmployeesOfRepository();

    // assert
    assertThat(actual).isEqualTo(expected);
  }
}