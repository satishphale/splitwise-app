package com.demo.splitwiseapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private Double totalAmount;
    @ElementCollection
    private Map<User,Integer> paidBy;
    @ElementCollection
    private Map<User,Integer> owedBy;
}
