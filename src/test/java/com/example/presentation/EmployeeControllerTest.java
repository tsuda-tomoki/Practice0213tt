package com.example.presentation;

import static com.example.TestUtils.readFrom;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.domain.entity.Employee;
import com.example.domain.service.EmployeeService;
import com.example.presentation.exception.EmployeesNotFoundException;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
  void GETでエンドポイントに何もが指定されていない場合() throws Exception {
    // assert
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string("Success! You've accessed the root URL of /v1/employees."));
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

  @Test
  void GETでエンドポイントにIDが指定された場合ID検索が実行される() throws Exception {
    // setup
    Employee expected = new Employee("1", "Taro", "Yamada");

    doReturn(expected).when(employeeService).findByEmployeeIdOfService("1");

    mockMvc.perform(get("/v1/employees/1"))
        .andExpect(status().isOk())
        .andExpect(content().json(readFrom("test-json/IdEmployee.json")));
  }

  @Test
  void POSTでエンドポイントにemployeesが指定された場合追加が実行される() throws Exception {
    // setup
    PostEmployeeRequest expected = new PostEmployeeRequest();
    expected.setId("3");
    expected.setFirstName("Hanako");
    expected.setLastName("Shirato");

    doNothing().when(employeeService).insertByEmployeeOfService(expected);

    mockMvc.perform(post("/v1/employees")
            .content(readFrom("test-json/postEmployee.json"))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void DELETEでエンドポイントにidが指定されたときそれを削除する() throws Exception {
    // setup
    doNothing().when(employeeService).deleteByEmployeeOfService("1");

    // assert
    mockMvc.perform(delete("/v1/employees/1")
    ).andExpect(status().isNoContent());
  }

  @Test
  void PATCHでエンドポイントにidが指定された場合指定のidの従業員の名前が更新される() throws Exception {
    // setup
    UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest("Taro", "Yama");
    doNothing().when(employeeService).updateByEmployeeOfService("1", updateEmployeeRequest);

    // assert
    mockMvc.perform(patch("/v1/employees/1")
            .content(readFrom("test-json/patchEmployee.json"))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  @Test
  void POSTでエンドポイントにemployeesが指定され不正なJSONが来たら400エラーを出す() throws Exception {
    // assert
    mockMvc.perform(post("/v1/employees")
            .content(readFrom("test-json/postEmployee-bad.json"))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  void DELETEでエンドポイントに不正なidが指定されたとき400エラー() throws Exception {
    // setup
    doThrow(new EmployeesNotFoundException("999"))
        .when(employeeService)
        .deleteByEmployeeOfService("999");

    // assert
    mockMvc.perform(delete("/v1/employees/999")
    ).andExpect(status().isBadRequest());
  }

  @Test
  void PATCHでエンドポイントに不正なidが指定されたとき400エラー() throws Exception {
    // setup
    UpdateEmployeeRequest expected = new UpdateEmployeeRequest("Taro", "Yama");

    doThrow(new EmployeesNotFoundException("999"))
        .when(employeeService)
        .updateByEmployeeOfService("999", expected);

    // assert
    mockMvc.perform(patch("/v1/employees/999")
    ).andExpect(status().isBadRequest());
  }
}
