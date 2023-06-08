package com.example.Insurance_and_Claims;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

@EnableEncryptableProperties
public class InsuranceAndClaimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceAndClaimsApplication.class, args);
	}

}
