package com.demo.splitwiseapp.dtos;

import com.demo.splitwiseapp.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SettleupResponseDto {
    private List<Transaction> transactions;
}
