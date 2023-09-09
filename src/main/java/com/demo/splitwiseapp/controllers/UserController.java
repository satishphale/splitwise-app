package com.demo.splitwiseapp.controllers;

import com.demo.splitwiseapp.dtos.*;
import com.demo.splitwiseapp.model.Transaction;
import com.demo.splitwiseapp.model.User;
import com.demo.splitwiseapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    ResponseDto<RegisterUserResponseDto> registerUser(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.registerUser(registerUserRequestDto.getName(),
                registerUserRequestDto.getPassword(),
                registerUserRequestDto.getPhoneNumber());

        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setPhoneNumber(user.getPhoneNumber());

        ResponseDto<RegisterUserResponseDto> response = new ResponseDto<>();
        response.setData(new RegisterUserResponseDto());
        response.getData().setUser(userDto);
        response.setResponseStatus(ResponseStatus.SUCCESS);

        return response;
    }

    public SettleupResponseDto settleUp(SettleupUseRequestDto settleupUseRequestDto) {
        List<Transaction> transactions = userService.settleup(settleupUseRequestDto.getUser_id());
        SettleupResponseDto responseDto = new SettleupResponseDto();
        responseDto.setTransactions(transactions);
        return responseDto;
    }
}
