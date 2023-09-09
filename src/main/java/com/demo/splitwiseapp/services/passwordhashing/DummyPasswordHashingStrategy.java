package com.demo.splitwiseapp.services.passwordhashing;


import org.springframework.stereotype.Service;

@Service
public class DummyPasswordHashingStrategy implements PasswordHashingStrategy{
    @Override
    public String hash(String originalPassword) {
        return originalPassword + "hashed";
    }
}
