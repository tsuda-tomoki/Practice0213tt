package com.example.presentation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record PostEmployeeRequest(
    @NotBlank
    @JsonProperty("firstName")
    String firstName,

    @NotBlank
    @JsonProperty("lastName")
    String lastName
) {

}
