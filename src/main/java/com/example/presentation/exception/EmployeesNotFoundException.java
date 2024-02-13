package com.example.presentation.exception;

/**
 * 従業員が見つからない場合にスローされる例外クラス.
 */
public class EmployeesNotFoundException extends RuntimeException {

  /**
   * 指定されたメッセージを持つ EmployeesNotFoundException を構築します.
   *
   * @param message 例外の詳細メッセージ
   */
  public EmployeesNotFoundException(String message) {
    super(message);
  }
}
