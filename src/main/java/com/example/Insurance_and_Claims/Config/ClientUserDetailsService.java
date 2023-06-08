//package com.example.Insurance_and_Claims.Config;
//
//import com.example.Insurance_and_Claims.Model.Client;
//import com.example.Insurance_and_Claims.Repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//
//public class ClientUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private ClientRepository clientRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     Optional<Client> client=clientRepository.findByUsername(username);
//     return client.map(ClientUserDetails::new)
//             .orElseThrow(()->new UsernameNotFoundException("User not found"+username));
//
//    }
//}
