package com.iamdalibor.Tasky.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Task {
    @Id
    private Long id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private TaskPriority taskPriority;

    @OneToMany
    private List<Tag> tags;

    private TaskStatus status;

    @OneToOne
    private User assignedTo;
}
