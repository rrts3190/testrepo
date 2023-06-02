package com.cwr.user.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
