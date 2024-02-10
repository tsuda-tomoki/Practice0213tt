package com.example.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.domain.entity.Employee;
import com.example.infrastructure.mapper.EmployeeMapper;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import java.sql.DriverManager;
import java.util.List;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DBRider
@DBUnit
class EmployeeMapperTest {
  private static final String DB_URL = "jdbc:h2:mem:test;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false";
  private static final String DB_USER = "sa";
  private static final String DB_PASSWORD = "sa";

  private static final ConnectionHolder connectionHolder =
      () -> DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

  @Autowired
  EmployeeMapper sut;

  @BeforeAll
  static void setUpAll() {
    Flyway.configure().dataSource(DB_URL, DB_USER, DB_PASSWORD).load().migrate();
  }

  @Test
  @DataSet(value = "test-yml/all-Employees.yml")
  @ExpectedDataSet(value = "test-yml/all-Employees.yml")
  void 全件検索ができる場合() throws Exception {
    // setup
    List<Employee> expected = List.of(
        new Employee("1", "Taro", "Yamada"),
        new Employee("2", "Jiro", "Yamada")
    );

    // execute
    List<Employee> actual = sut.findAll();

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  @DataSet(value = "test-yml/one-Employee.yml")
  @ExpectedDataSet(value = "test-yml/one-Employee.yml")
  void ID指定で検索ができる場合() throws Exception {
    // setup
    Employee expected = new Employee("1", "Taro", "Yamada");

    // execute
    Employee actual = sut.findById("1");

    // assert
    assertThat(actual).isEqualTo(expected);
  }
}
