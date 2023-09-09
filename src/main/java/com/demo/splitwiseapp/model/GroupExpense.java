package com.demo.splitwiseapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "group_expense")
public class GroupExpense extends BaseModel {
    @ManyToOne
    private Group group;
    @OneToOne
    private Expense expense;
}
