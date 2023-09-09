package com.demo.splitwiseapp.strategies.settleup;

import com.demo.splitwiseapp.model.Expense;
import com.demo.splitwiseapp.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GreedySettleupExpenseStrategy implements SettleupGroupExpenseStrategy{

    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        return null;
    }
}
