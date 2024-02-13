package com.example.presentation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * 従業員情報の更新リクエストを表すオブジェクト.
 *
 * @param firstName 名
 * @param lastName  姓
 */
public record UpdateEmployeeRequest(
    @NotBlank
    @JsonProperty("firstName")
    String firstName,

    @NotBlank
    @JsonProperty("lastName")
    String lastName
) {
}
