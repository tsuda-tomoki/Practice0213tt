package com.example.infrastructure.mapper;

import com.example.domain.entity.Employee;
import com.example.domain.request.PostEmployeeRequest;
import com.example.domain.request.UpdateEmployeeRequest;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * employees テーブルのマッピングを行うマッパーインターフェース.
 */
@Mapper
public interface EmployeeMapper {

  /**
   * 全ての従業員を取得します.
   *
   * @return 従業員情報のリスト
   */
  @Select("SELECT id, first_name, last_name FROM employees")
  List<Employee> findAll();

  /**
   * 指定された従業員IDの従業員情報を取得します.
   *
   * @param id 従業員ID
   * @return 従業員情報
   */
  @Select("SELECT id, first_name, last_name FROM employees WHERE id = #{id}")
  Employee findById(String id);

  /**
   * 従業員を新規追加します.
   *
   * @param postEmployeeRequest 新しい従業員情報を含むリクエスト
   * @return 追加された従業員情報の数
   */
  @Insert("INSERT INTO employees (id, first_name, last_name)"
      + "VALUES (nextval('EMPLOYEE_ID_SEQ'), #{firstName}, #{lastName})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  Integer insert(PostEmployeeRequest postEmployeeRequest);

  /**
   * 指定された従業員IDの従業員情報を削除します.
   *
   * @param id 従業員ID
   * @return 削除された従業員情報の数
   */
  @Delete("DELETE FROM employees WHERE id = #{id}")
  Integer delete(String id);

  /**
   * 指定された従業員IDの従業員情報を更新します.
   *
   * @param id 従業員ID
   * @param updateEmployeeRequest 更新する従業員情報を含むリクエスト
   * @return 更新された従業員情報の数
   */
  @Update("UPDATE employees SET first_name ="
      + "#{updateEmployee.firstName}, last_name = #{updateEmployee.lastName} WHERE id = #{id}")
  Integer update(
      @Param("id") String id,
      @Param("updateEmployee") UpdateEmployeeRequest updateEmployeeRequest);
}
