package com.demo.splitwiseapp.strategies.settleup;

import com.demo.splitwiseapp.model.Expense;
import com.demo.splitwiseapp.model.Transaction;

import java.util.List;

public interface SettleupGroupExpenseStrategy {
    List<Transaction> settle(List<Expense> expenses);
}
