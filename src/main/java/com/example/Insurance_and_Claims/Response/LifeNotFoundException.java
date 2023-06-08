package com.example.Insurance_and_Claims.Response;

public class LifeNotFoundException extends RuntimeException {

    public LifeNotFoundException(Long life_id){
        super("Could Not Found life condition with id "+life_id);
    }
}
