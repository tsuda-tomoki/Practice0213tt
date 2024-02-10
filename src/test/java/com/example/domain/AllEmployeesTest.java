package com.example.domain;

import com.example.presentation.response.AllEmployeesResponse;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AllEmployeesTest {

  @Test
  void 従業員リストが空の場合() {
    // assert
    assertThatThrownBy(() -> new AllEmployeesResponse(emptyList()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("従業員リストが不正です。");
  }

  @Test
  void 従業員リストがnullの場合() {
    // assert
    assertThatThrownBy(() -> new AllEmployeesResponse(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("従業員リストが不正です。");
  }
}
