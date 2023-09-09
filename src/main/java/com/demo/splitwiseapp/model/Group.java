package com.demo.splitwiseapp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel {
    private String name;
    @ManyToMany
    private List<User> members;

    @ManyToMany
    private List<User> admins;
}
