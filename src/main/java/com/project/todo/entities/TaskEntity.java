package com.project.todo.entities;

import com.project.todo.enums.Status;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity {
    @Id
    private String id;
    private String description;
    private String startTime;
    private String completedTime;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String isActive;
}
