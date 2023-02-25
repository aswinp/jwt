package com.aswin.auth.jwt.service;

import com.aswin.auth.jwt.entities.MyUser;
import com.aswin.auth.jwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myuser = userRepository.findByUsername(username);
        UserDetails userDetails = MyUser.builder()
                .username(myuser.getUsername())
                .password(myuser.getPassword())
                .roles(myuser.getRoles())
                .build();
        return userDetails;
    }
}
