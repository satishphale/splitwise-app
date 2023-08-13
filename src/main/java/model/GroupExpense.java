package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "group_expense")
public class GroupExpense {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToOne
    private Expense expense;
}
