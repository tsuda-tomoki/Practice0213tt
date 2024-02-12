package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.example.presentation.request.UpdateEmployeeRequest;
import it.unibo.tuprolog.solve.stdlib.primitive.Op;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {
  @Mock
  EmployeeRepository employeeRepository;

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
    Optional<Employee> expected = Optional.of(new Employee("1", "Taro", "Yamada"));

    when(employeeRepository.findByEmployeeOfRepository("1")).thenReturn(expected);

    // execute
    Optional<Employee> actual = employeeService.findByEmployeeIdOfService("1");

    // assert
    assertThat(actual).isEqualTo(expected);
  }

//  @Test
//  void 追加ができる場合() {
//    // setup
//    Employee expected = new Employee("3", "Hanako", "Shirato");
//
//    when(employeeRepository.insertByEmployeeOfRepositroy(expected)).thenReturn(expected);
//
//    // execute
//    Employee actual = employeeService.insertByEmployeeOfService(expected);
//
//    // assert
//    assertThat(actual).isEqualTo(expected);
//  }

  @Test
  void 削除ができる場合() {
    // setup
    Optional<Employee> employee = Optional.of(new Employee("1", "Taro", "Yamada"));

    doReturn(employee).when(employeeRepository).findByEmployeeOfRepository("1");

    // execute & assert
    assertThatCode(() -> employeeService.deleteByEmployeeOfService("1"))
        .doesNotThrowAnyException();
  }

  @Test
  void 更新ができる場合() {
    // setup
    UpdateEmployeeRequest expected = new UpdateEmployeeRequest("Taro", "Yama");

    Optional<Employee> employee = Optional.of(new Employee("1", "Taro", "Yamada"));

    doReturn(employee).when(employeeRepository).findByEmployeeOfRepository("1");

    // execute & assert
    assertThatCode(() -> employeeService.updateByEmployeeOfService("1", expected))
        .doesNotThrowAnyException();
  }
}
