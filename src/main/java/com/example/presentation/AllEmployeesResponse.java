package com.example.presentation;

import com.example.domain.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 全従業員のリストを表す Value Object.
 *
 * @param employeeList 従業員リスト.  null であってはなりません.
 */
public record AllEmployeesResponse(
    @JsonProperty("employees") List<Employee> employeeList
) {
}
