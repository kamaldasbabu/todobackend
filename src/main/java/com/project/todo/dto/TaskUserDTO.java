package com.project.todo.dto;

import com.project.todo.enums.Status;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskUserDTO {
    @Id
    private String id;
    private String taskId;
    private String userId;
    private Integer priority;
    private String date;
    private Status status;
}
