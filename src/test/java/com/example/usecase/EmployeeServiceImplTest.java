package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {
  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeServiceImpl employeeService;

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

    when(employeeRepository.findByAllEmployeesOfRepository()).thenReturn(expected);

    // execute
    List<Employee> actual = employeeService.findByAllEmployeesOfService();

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void ID検索ができる場合() {
    // setup
    Employee expected = new Employee("1", "Taro", "Yamada");

    when(employeeRepository.findByEmployeeOfRepository(expected.id())).thenReturn(expected);

    // execute
    Employee actual = employeeService.findByEmployeeIdOfService("1");

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void 追加ができる場合() {
    // setup
    Employee expected = new Employee("3", "Hanako", "Shirato");

    when(employeeRepository.insertByEmployeeOfRepositroy(expected)).thenReturn(expected);

    // execute
    Employee actual = employeeService.insertByEmployeeOfService(expected);

    // assert
    assertThat(actual).isEqualTo(expected);
  }
}
