package model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "participant_id")
    private List<User> participants;

    @OneToMany
    @JoinColumn(name = "admin_id")
    private List<User> admins;
}
