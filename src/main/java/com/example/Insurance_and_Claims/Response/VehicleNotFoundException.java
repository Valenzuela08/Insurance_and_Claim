package com.example.Insurance_and_Claims.Response;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(Long id) {
        super("Could Not Found Vehicle condition with id "+id);
    }
}
