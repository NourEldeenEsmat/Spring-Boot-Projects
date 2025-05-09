package com.example.Simple_Ecommerce_App.Errors;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ErrorResponse {
    private Boolean success;
    private String message;
    private LocalDateTime time;
    private List<String> details;

    public ErrorResponse(String localizedMessage, List<String> details) {
        message=localizedMessage;
        this.details=details;
        this.time=LocalDateTime.now();
        this.success=Boolean.FALSE;
    }
}
