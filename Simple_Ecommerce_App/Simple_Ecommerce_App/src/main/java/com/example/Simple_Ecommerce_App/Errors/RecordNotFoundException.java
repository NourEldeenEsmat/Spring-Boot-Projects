package com.example.Simple_Ecommerce_App.Errors;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
