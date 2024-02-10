package com.example.presentation;

import static com.example.TestUtils.readFrom;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.domain.Employee;
import com.example.domain.EmployeeService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EmployeeService employeeService;

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

    doReturn(expected).when(employeeService).findByAllEmployeesOfService();

    mockMvc.perform(get("/v1/employees"))
        .andExpect(status().isOk())
        .andExpect(content().json(readFrom("test-json/AllEmployee.json")));
  }
}
