package com.project.todo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="task_user")
@Data
@NoArgsConstructor
public class TaskUserEntity {
    @Id
    private  String id;
    private  String taskId;
    private  String userId;
    private  Integer priority;
    private  String date;
    private  String status;
}
