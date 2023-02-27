package com.iamdalibor.Tasky.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    public Tag(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
