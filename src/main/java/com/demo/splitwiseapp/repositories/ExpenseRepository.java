package com.demo.splitwiseapp.repositories;

import com.demo.splitwiseapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByPaidByContainingorOwedByContaining(Long userid, Long userid2);
}
