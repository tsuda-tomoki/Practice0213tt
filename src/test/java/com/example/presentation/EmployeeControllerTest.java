package com.example.presentation;

import static com.example.TestUtils.readFrom;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.domain.AllEmployees;
import com.example.domain.Employee;
import com.example.domain.EmployeeService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private EmployeeController employeeController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void GETでエンドポイントにemployeesが指定された場合全件検索が実行される() throws Exception {
    // setup
    List<Employee> expected = List.of(
        new Employee("1", "Taro", "Yamada"),
        new Employee("2", "Jiro", "Yamada")
        );

    when(employeeService.findByAllEmployeesOfService()).thenReturn(expected);

    mockMvc.perform(get("/v1/employees"))
        .andExpect(status().isOk())
        .andExpect(content().json(readFrom("test-json/AllEmployee.json")));
  }
}
