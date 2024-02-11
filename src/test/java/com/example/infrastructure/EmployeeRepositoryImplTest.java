package com.example.infrastructure;

import com.example.domain.entity.Employee;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.example.infrastructure.repository.EmployeeRepositoryImpl;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class EmployeeRepositoryImplTest {

  @Mock
  private EmployeeMapper employeeMapper;

  @InjectMocks
  private EmployeeRepositoryImpl employeeRepository;

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

  @Test
  void ID検索ができる場合() {
    // setup
    Employee employee = new Employee("1", "Taro", "Yamada");

    Optional<Employee> expected = Optional.of(new Employee("1", "Taro", "Yamada"));

    when(employeeMapper.findById(employee.id())).thenReturn(employee);

    // execute
    Optional<Employee> actual = employeeRepository.findByEmployeeOfRepository("1");

    // assert
    assertThat(actual).isEqualTo(expected);
  }

//  @Test
//  void 追加ができる場合() {
//    // setup
//    Employee expected = new Employee("3", "Hanako", "Shirato");
//
//    when(employeeMapper.insert(expected)).thenReturn(1);
//
//    // execute
//    Employee actual = employeeRepository.insertByEmployeeOfRepositroy(expected);
//
//    // assert
//    assertThat(actual).isEqualTo(expected);
//  }

  @Test
  void 削除ができる場合() {
    // setup
    when(employeeMapper.delete("1")).thenReturn(1);

    // execute & assert
    assertThatCode(() -> employeeRepository.deleteByEmployeeOfRepository("1"))
        .doesNotThrowAnyException();
  }

  @Test
  void 更新ができる場合() {
    // setup
    UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest("Taro", "Yama");
    when(employeeMapper.update("1", updateEmployeeRequest)).thenReturn(1);

    // execute & assert
    assertThatCode(() -> employeeRepository.updateByEmployeeOfRepository("1", updateEmployeeRequest))
        .doesNotThrowAnyException();
  }
}
