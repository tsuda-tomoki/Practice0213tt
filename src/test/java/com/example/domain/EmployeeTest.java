package com.example.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EmployeeTest {

  @ParameterizedTest
  @CsvSource({
      "aaa, Taro, Yamada",
      " , Taro, Yamada",
      "'', Taro, Yamada",
      "-1, Taro, Yamada"
  })
  void 従業員IDがガード条件に違反する場合(String id, String firstName, String lastName) throws Exception {
    // assert
    assertThatThrownBy(() -> new Employee(id, firstName, lastName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("従業員情報が不正です。");
  }

  @ParameterizedTest
  @CsvSource({
      "1, 1111, Yamada",
      "1, , Yamada",
      "1, '', Yamada",
  })
  void 従業員の名前がガード条件に違反する場合(String id, String firstName, String lastName)
      throws Exception {
    // assert
    assertThatThrownBy(() -> new Employee(id, firstName, lastName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("従業員情報が不正です。");
  }

  @ParameterizedTest
  @CsvSource({
      "1, Taro, 111111",
      "1, Taro, ",
      "1, Taro, ''",
  })
  void 従業員の名字がガード条件に違反する場合(String id, String firstName, String lastName)
      throws Exception {
    // assert
    assertThatThrownBy(() -> new Employee(id, firstName, lastName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("従業員情報が不正です。");
  }
}
