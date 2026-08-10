package com.ramjo.fleet_management.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
public class ApiResponse<T> {
    private final Instant timestamp;
    private final T data;
    private final String message;
    private final boolean success;

    public ApiResponse(Boolean success, T data, String message){
        this.success = success;
        this.data = data;
        this.message =message;
        this.timestamp = Instant.now();
    }

    public static <T> ApiResponse<T> ok(T data, String message){
        return new ApiResponse<>(true, data, message);
    }

    public static <T> ApiResponse<T> error(T data, String message){
        return new ApiResponse<>(false, data, message);
    }
}
