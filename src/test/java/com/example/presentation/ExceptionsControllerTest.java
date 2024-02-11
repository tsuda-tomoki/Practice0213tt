package com.example.presentation;

import static com.example.TestUtils.readFrom;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.EmployeeService;
import com.example.presentation.exception.EmployeesNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ExceptionsControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EmployeeService employeeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
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
}
