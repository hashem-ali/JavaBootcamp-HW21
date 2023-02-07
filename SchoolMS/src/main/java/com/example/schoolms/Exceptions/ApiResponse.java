package com.example.schoolms.Exceptions;

public class ApiResponse extends RuntimeException{
    public ApiResponse(String message){
        super(message);
    }
}
