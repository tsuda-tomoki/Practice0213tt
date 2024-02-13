package com.example.domain.service;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;

/**
 * 従業員関連のサービスを提供するインターフェース.
 */
public interface EmployeeService {

  /**
   * 全ての従業員を取得します.
   *
   * @return 従業員情報のリスト
   */
  List<Employee> findByAllEmployeesOfService();

  /**
   * 指定された従業員IDの従業員を取得します.
   *
   * @param id 従業員ID
   * @return 従業員情報
   */
  Employee findByEmployeeIdOfService(String id);

  /**
   * 新しい従業員を追加します.
   *
   * @param postEmployeeRequest 新しい従業員情報を含むリクエスト
   */
  void insertByEmployeeOfService(PostEmployeeRequest postEmployeeRequest);

  /**
   * 指定された従業員IDの従業員情報を削除します.
   *
   * @param id 従業員ID
   */
  void deleteByEmployeeOfService(String id);

  /**
   * 指定された従業員IDの従業員情報を更新します.
   *
   * @param id 従業員ID
   * @param updateEmployeeRequest 更新する従業員情報を含むリクエスト
   */
  void updateByEmployeeOfService(String id, UpdateEmployeeRequest updateEmployeeRequest);
}
