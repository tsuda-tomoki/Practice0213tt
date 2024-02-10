package com.example.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * 従業員情報を表す Value Object.
 *
 * @param id        従業員ID. null であってはなりません.
 * @param firstName 従業員の名前. null であってはなりません.
 * @param lastName  従業員の名字. null であってはなりません.
 */
public record Employee(
    @JsonProperty("id") String id,
    @JsonProperty("firstName") String firstName,
    @JsonProperty("lastName") String lastName
) {

  /**
   * 従業員情報の Value Object を初期化します.
   *
   * @param id 従業員ID. null, 文字列, 空文字, 負の値であってはなりません.
   * @param firstName 従業員の名前. null, 空文字, 数字であってはなりません.
   * @param lastName 従業員の名字. null, 空文字, 数字であってはなりません.
   */
  public Employee {
    if (!isNumeric(id) || !isAlpha(firstName) || !isAlpha(lastName)) {
      throw new IllegalArgumentException("従業員情報が不正です。");
    }
  }
}
