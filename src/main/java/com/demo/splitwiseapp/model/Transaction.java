package com.demo.splitwiseapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    User from;
    User to;
    int amount;
}
