package com.example.domain.repository;

import com.example.domain.entity.Employee;
import com.example.domain.request.PostEmployeeRequest;
import com.example.domain.request.UpdateEmployeeRequest;
import java.util.List;

/**
 * employees テーブルにアクセスするためのリポジトリ.
 */
public interface EmployeeRepository {

  /**
   * 全ての従業員を取得します.
   *
   * @return 従業員情報のリスト
   */
  List<Employee> findByAllEmployeesOfRepository();

  /**
   * 指定された従業員IDの従業員を取得します.
   *
   * @param id 従業員ID
   * @return 従業員情報
   */
  Employee findByEmployeeOfRepository(String id);

  /**
   * 新しい従業員を追加します.
   *
   * @param postEmployeeRequest 新しい従業員情報を含むリクエスト
   */
  void insertByEmployeeOfRepositroy(PostEmployeeRequest postEmployeeRequest);

  /**
   * 指定された従業員IDの従業員を削除します.
   *
   * @param id 従業員ID
   */
  void deleteByEmployeeOfRepository(String id);

  /**
   * 指定された従業員IDの従業員情報を更新します.
   *
   * @param id 従業員ID
   * @param updateEmployeeRequest 更新する従業員情報を含むリクエスト
   */
  void updateByEmployeeOfRepository(String id, UpdateEmployeeRequest updateEmployeeRequest);
}
