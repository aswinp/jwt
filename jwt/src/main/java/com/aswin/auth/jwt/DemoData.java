package com.aswin.auth.jwt;

import com.aswin.auth.jwt.entities.MyUser;
import com.aswin.auth.jwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DemoData implements CommandLineRunner {

    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        MyUser userAswin = MyUser
                .builder()
                .roles(Collections.singleton(USER))
                .username("Aswin")
                .password(bCryptPasswordEncoder.encode("Ruchika*2607"))
                .build();

        MyUser userRuchika = MyUser
                        .builder()
                        .roles(Collections.singleton(ADMIN))
                        .username("Ruchika")
                        .password(bCryptPasswordEncoder.encode("Aswin*0505"))
                        .build();

        userRepository.save(userRuchika);
        userRepository.save(userAswin);
    }
}