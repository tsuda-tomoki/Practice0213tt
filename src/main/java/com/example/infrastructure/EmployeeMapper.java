package com.example.infrastructure;

import com.example.domain.Employee;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * employees の テーブルにアクセスする Mapper インターフェイス.
 */
@Mapper
public interface EmployeeMapper {

  @Select("SELECT id, first_name, last_name FROM employees")
  List<Employee> findAll();
}
