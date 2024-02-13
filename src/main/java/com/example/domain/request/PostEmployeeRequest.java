package com.example.domain.request;

import jakarta.validation.constraints.NotBlank;

/**
 * 従業員情報の新規追加リクエストを表すオブジェクト.
 */
public class PostEmployeeRequest {

  @NotBlank
  String firstName;
  @NotBlank
  String lastName;
  String id;

  /**
   * 従業員の名を設定します.
   *
   * @param firstName 従業員の名.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * 従業員の姓を設定します.
   *
   * @param lastName 従業員の姓.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * 従業員のIDを取得します.
   *
   * @return 従業員ID.
   */
  public String getId() {
    return id;
  }

  /**
   * 従業員のIDを設定します.
   *
   * @param id 従業員ID.
   */
  public void setId(String id) {
    this.id = id;
  }
}
