package com.demo.splitwiseapp.controllers;

import com.demo.splitwiseapp.dtos.SettleupGroupRequestDto;
import com.demo.splitwiseapp.dtos.SettleupResponseDto;
import com.demo.splitwiseapp.model.Transaction;
import com.demo.splitwiseapp.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupController {
    /**
     *
     */
    @Autowired
    private GroupService groupService;

    public SettleupResponseDto settleUp(SettleupGroupRequestDto settleupGroupRequestDto) {

        List<Transaction> transactions = groupService.settleUp(settleupGroupRequestDto.getGroup_id());

        SettleupResponseDto response = new SettleupResponseDto();
        response.setTransactions(transactions);

        return response;

    }
}
