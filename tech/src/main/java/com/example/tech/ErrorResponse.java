package com.example.tech;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String status;
    private ErrorResponseDetail errorResponse;

      public ErrorResponse(String status, ErrorResponseDetail errorResponse) {
        this.status = status;
        this.errorResponse = errorResponse;
    }
}
