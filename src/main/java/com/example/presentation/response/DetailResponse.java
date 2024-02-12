package com.example.presentation.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DetailResponse(@JsonProperty("Details") String message) {

}
