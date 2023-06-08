package com.example.Insurance_and_Claims.Response;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id){
        super("Could Not Found client with id "+id);
    }
}
