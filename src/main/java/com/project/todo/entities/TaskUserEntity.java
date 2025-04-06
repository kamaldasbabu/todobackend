package com.project.todo.entities;


import com.project.todo.enums.Status;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

@Entity(name="task_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskUserEntity {
    @Id
    private  String id;
    @Nonnull
    private  String taskId;
    private  String userId;
    private  Integer priority;
    private  String date;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String isActive;
}
