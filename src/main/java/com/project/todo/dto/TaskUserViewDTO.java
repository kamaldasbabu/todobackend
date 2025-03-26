package com.project.todo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TaskUserViewDTO {
    private String id;
    private String name;
    private List<TaskDTO> tasks;

}
