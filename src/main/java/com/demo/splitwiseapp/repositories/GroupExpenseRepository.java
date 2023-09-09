package com.demo.splitwiseapp.repositories;

import com.demo.splitwiseapp.model.Expense;
import com.demo.splitwiseapp.model.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {

    List<GroupExpense> findAllByGroup(Long group_id);
}
