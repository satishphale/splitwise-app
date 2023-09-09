package com.demo.splitwiseapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    String name;
    String password;
    String phoneNumber;
    String email;
}
