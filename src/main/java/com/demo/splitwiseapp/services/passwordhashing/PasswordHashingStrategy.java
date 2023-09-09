package com.demo.splitwiseapp.services.passwordhashing;


public interface PasswordHashingStrategy {
    String hash(String originalPassword);
}
