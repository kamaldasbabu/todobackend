package com.project.todo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="task_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskUserEntity {
    @Id
    private  String id;
    private  String taskId;
    private  String userId;
    private  Integer priority;
    private  String date;
    private  String status;
    private String isActive;
}
