package com.example.Insurance_and_Claims.Config;

import com.example.Insurance_and_Claims.Model.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    //Authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin= User.withUsername("Glen")
                .password(encoder.encode("Pass@1234"))
                .roles("ADMIN")
                .build();
//        UserDetails user= User.withUsername("Glen08")
//                .password(encoder.encode("Pass@12345"))
//                .roles("USER")
//                .build();
        return new InMemoryUserDetailsManager(admin);
//        return new ClientUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       return http
//               .authorizeHttpRequests()
//               .anyRequest()
//               .authenticated()
//               .and()
//               .httpBasic();

        return  http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("")
                .hasRole("ADMIN")
                .requestMatchers("")
                .hasRole("USER")
                .requestMatchers("").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and().build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }

}
