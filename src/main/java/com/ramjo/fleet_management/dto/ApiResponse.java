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

    public ApiResponse(Boolean success, String message, T data){
        this.success = success;
        this.data = data;
        this.message =message;
        this.timestamp = Instant.now();
    }

    public static <T> ApiResponse<T> ok(T data, String message){
        return new ApiResponse<>(true, message, data);
    }

    public static <T> ApiResponse<T> error(String message){
        return new ApiResponse<>(false, message, null);
    }
}
