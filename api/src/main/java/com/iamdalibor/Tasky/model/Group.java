package com.iamdalibor.Tasky.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<User> managers;
    @ManyToMany
    private List<User> members;

    public Group(String name, List<User> managers, List<User> members) {
        this.name = name;
        this.managers = managers;
        this.members = members;
    }
}
