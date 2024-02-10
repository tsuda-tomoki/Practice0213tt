package com.example.infrastructure.mapper;

import com.example.domain.entity.Employee;
import com.example.presentation.request.PostEmployeeRequest;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
  Integer insert(Employee employee);

}
