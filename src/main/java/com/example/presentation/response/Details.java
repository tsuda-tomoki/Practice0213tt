package com.example.presentation.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Details(@JsonProperty("Details") String message) {

}
