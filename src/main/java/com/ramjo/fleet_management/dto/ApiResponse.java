package com.ramjo.fleet_management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private final Instant timestamp;
    private final T data;
    private final T errors;
    private final String message;
    private final boolean success;

    public ApiResponse(Boolean success, String message, T data, T errors){
        this.success = success;
        this.data = data;
        this.errors = errors;
        this.message =message;
        this.timestamp = Instant.now();
    }

    public static <T> ApiResponse<T> ok(T data, String message){
        return new ApiResponse<>(true, message, data, null);
    }

    public static <T> ApiResponse<T> error(T errors, String message){
        return new ApiResponse<>(false, message, null, errors);
    }
}
