package com.demo.splitwiseapp.services;

import com.demo.splitwiseapp.model.Expense;
import com.demo.splitwiseapp.model.Transaction;
import com.demo.splitwiseapp.model.User;
import com.demo.splitwiseapp.repositories.ExpenseRepository;
import com.demo.splitwiseapp.repositories.UserRepository;
import com.demo.splitwiseapp.services.passwordhashing.PasswordHashingStrategy;
import com.demo.splitwiseapp.strategies.settleup.SettleupGroupExpenseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired //find the implementation of this strategy
    private PasswordHashingStrategy passwordHashingStrategy;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private SettleupGroupExpenseStrategy settleupGroupExpenseStrategy;


    private String hashedPassword(String password) {
        return password + "hashed";
    }
    public User registerUser(String name, String password, String phoneNumber) { // service should never be depend on request so we can't user DTOs here
        //hash password
        //String hasedPassord = hashedPassword(password); // violating SRP(in future some other class want to hash password or we want hash password in different way)
        String hasedPassord = passwordHashingStrategy.hash(password);
        //create user object ->no id
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setHashedPassword(hasedPassord);
        //save user object -> id present
        User savedUser = userRepository.save(user);
        //return saved object
        return savedUser;
    }

    public List<Transaction> settleup(Long user_id) {
        //1.get the expenses for user
        List<Expense> expenses = expenseRepository.findAllByPaidByContainingorOwedByContaining(user_id,user_id);
        //2.run the settleup algo
        List<Transaction> transactions = settleupGroupExpenseStrategy.settle(expenses);
        //3.filter transaction that is user part of
        List<Transaction> filteredTransactions = new ArrayList<>();

        User user = userRepository.getUserById(user_id).get();
        for (Transaction transaction : transactions) {
            if (transaction.getFrom().getPhoneNumber() == user.getPhoneNumber() ||
                    transaction.getTo().getPhoneNumber() == user.getPhoneNumber()) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
