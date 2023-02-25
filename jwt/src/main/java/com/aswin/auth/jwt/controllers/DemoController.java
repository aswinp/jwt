package com.aswin.auth.jwt.controllers;

import com.aswin.auth.jwt.dto.AuthRequest;
import com.aswin.auth.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class DemoController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    private static final String HELLO = "Welcome to authenticated call";
    @GetMapping("demo")
    public String demo(){
        return HELLO;
    }

    @PostMapping("authenticate")
    public String authenticateAndGenerateToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
             return jwtService.generateToken(authRequest.getUserName());
        }
        throw new UsernameNotFoundException("user " +authRequest.getUserName()+" not found");
    }
}
