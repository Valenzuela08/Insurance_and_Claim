package com.example.Insurance_and_Claims.Response;

public class InsuranceNotFoundException extends RuntimeException {

    public InsuranceNotFoundException(Long insurance_id){
        super("Could Not Found insurance with id "+insurance_id);
    }

}
