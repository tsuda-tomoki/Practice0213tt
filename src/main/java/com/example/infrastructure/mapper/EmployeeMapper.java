package com.example.infrastructure.mapper;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import com.example.presentation.request.UpdateEmployeeRequest;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * employees の テーブルにアクセスする Mapper インターフェイス.
 */
@Mapper
public interface EmployeeMapper {

  @Select("SELECT id, first_name, last_name FROM employees")
  List<Employee> findAll();

  @Select("SELECT id, first_name, last_name FROM employees WHERE id = #{id}")
  Employee findById(String id);

  @Insert("INSERT INTO employees (id, first_name, last_name) VALUES (nextval('EMPLOYEE_ID_SEQ'), #{firstName}, #{lastName})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  Integer insert(PostEmployeeRequest postEmployeeRequest);

  @Delete("DELETE FROM employees WHERE id = #{id}")
  Integer delete(String id);

  @Update("UPDATE employees SET first_name = #{updateEmployee.firstName}, last_name = #{updateEmployee.lastName} WHERE id = #{id}")
  Integer update(@Param("id") String id, @Param("updateEmployee") UpdateEmployeeRequest updateEmployeeRequest);

}
