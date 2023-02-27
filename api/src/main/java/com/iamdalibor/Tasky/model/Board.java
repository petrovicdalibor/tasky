package com.iamdalibor.Tasky.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<User> members;

    @OneToMany
    private List<Task> tasks;

    public Board(String name, List<User> members, List<Task> tasks) {
        this.name = name;
        this.members = members;
        this.tasks = tasks;
    }
}
