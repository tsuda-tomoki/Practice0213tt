package com.example.presentation.response;

import com.example.domain.entity.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 全従業員のリストを表すオブジェクト.
 *
 * @param employeeList 従業員リスト. null であってはなりません
 */
public record AllEmployeesResponse(
    @JsonProperty("employees") List<Employee> employeeList
) {
}
