package com.example.Simple_Ecommerce_App.Errors;

public class DoubleRecordException extends RuntimeException{
    public DoubleRecordException() {
    }

    public DoubleRecordException(String message) {
        super(message);
    }
}
