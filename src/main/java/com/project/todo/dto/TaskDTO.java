package com.project.todo.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {
    private String description;
    private String startTime;
    private String completedTime;
    private String status;
}
