package com.example.presentation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ExceptionHandResponse(
    @JsonProperty("code") String code,
    @JsonProperty("message") String message,
    @JsonProperty("details") List<Details> detailsList
) {
}
