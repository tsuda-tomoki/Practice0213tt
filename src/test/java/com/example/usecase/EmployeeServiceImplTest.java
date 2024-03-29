package com.example.usecase;

import com.example.domain.entity.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.request.PostEmployeeRequest;
import com.example.domain.request.UpdateEmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
    Employee expected = new Employee("1", "Taro", "Yamada");

    when(employeeRepository.findByEmployeeOfRepository("1")).thenReturn(expected);

    // execute
    Employee actual = employeeService.findByEmployeeIdOfService("1");

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void 追加ができる場合() {
    // setup
    PostEmployeeRequest postEmployeeRequest = new PostEmployeeRequest();
    postEmployeeRequest.setId("3");
    postEmployeeRequest.setFirstName("Hanako");
    postEmployeeRequest.setLastName("Shirato");

    Employee employee = new Employee("3", "Hanako", "Shirato");


    doReturn(employee).when(employeeRepository).findByEmployeeOfRepository("3");

    // execute & assert
    assertThatCode(() -> employeeService.insertByEmployeeOfService(postEmployeeRequest))
        .doesNotThrowAnyException();
  }

  @Test
  void 削除ができる場合() {
    // setup
    Employee employee = new Employee("1", "Taro", "Yamada");

    doReturn(employee).when(employeeRepository).findByEmployeeOfRepository("1");

    // execute & assert
    assertThatCode(() -> employeeService.deleteByEmployeeOfService("1"))
        .doesNotThrowAnyException();
  }

  @Test
  void 更新ができる場合() {
    // setup
    UpdateEmployeeRequest expected = new UpdateEmployeeRequest("Taro", "Yama");

    Employee employee = new Employee("1", "Taro", "Yamada");

    doReturn(employee).when(employeeRepository).findByEmployeeOfRepository("1");

    // execute & assert
    assertThatCode(() -> employeeService.updateByEmployeeOfService("1", expected))
        .doesNotThrowAnyException();
  }
}
