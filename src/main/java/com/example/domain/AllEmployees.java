package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

/**
 * 全従業員のリストを表す Value Object.
 *
 * @param employeeList 従業員リスト.  null であってはなりません.
 */
public record AllEmployees(@JsonProperty("employees") List<Employee> employeeList) {

  /**
   * 従業員リストの Value Object を初期化します.
   *
   * @param employeeList 従業員リスト. null, 空リストであってはなりません.
   */
  public AllEmployees {
    if (isEmpty(employeeList)) {
      throw new IllegalArgumentException("従業員リストが不正です。");
    }
  }
}
