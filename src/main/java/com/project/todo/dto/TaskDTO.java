package com.project.todo.dto;
import com.project.todo.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {
    private  String id;
    private String description;
    private String startTime;
    private String completedTime;
    private Status status;
    private String isActive;
}
