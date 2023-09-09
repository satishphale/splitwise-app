package com.demo.splitwiseapp.services;
import com.demo.splitwiseapp.model.Expense;
import com.demo.splitwiseapp.model.GroupExpense;
import com.demo.splitwiseapp.model.Transaction;
import com.demo.splitwiseapp.repositories.GroupExpenseRepository;
import com.demo.splitwiseapp.strategies.settleup.SettleupGroupExpenseStrategy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;
    @Autowired
    private SettleupGroupExpenseStrategy settleupGroupExpenseStrategy;

     public List<Transaction> settleUp(Long group_id) {

        List<GroupExpense> groupExpenses = groupExpenseRepository.findAllByGroup(group_id);

        List<Expense> expenses = new ArrayList<>();

        for (GroupExpense groupExpense : groupExpenses) {
            expenses.add(groupExpense.getExpense());
        }




        return settleupGroupExpenseStrategy.settle(expenses);
    }
}
