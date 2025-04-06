package com.project.todo.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.todo.dto.TaskDTO;
import com.project.todo.entities.TaskEntity;
import com.project.todo.exceptions.InvalidStatusException;
import com.project.todo.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TaskManager {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ObjectMapper objectMapper;

    //    @Autowired
//    InvalidStatusException invalidStatusException;
    public List<TaskDTO> getAllTask() {
        return taskRepository.findAll()
                .stream()
                .map(taskEntity -> TaskDTO.builder()
                        .id(taskEntity.getId())
                        .description(taskEntity.getDescription())
                        .startTime(taskEntity.getStartTime())
                        .completedTime(taskEntity.getCompletedTime())
                        .status(taskEntity.getStatus())
                        .build())
                .toList();
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {

        log.info("TaskDTO {}", taskDTO);
        TaskEntity taskEntity = TaskEntity.builder()
                .id(UUID.randomUUID().toString())
                .description(taskDTO.getDescription())
                .startTime(taskDTO.getStartTime())
                .completedTime(taskDTO.getCompletedTime())
                .status(taskDTO.getStatus())
                .isActive("T")
                .build();

        log.info("taskEntity {} ", taskEntity);

        taskRepository.save(taskEntity);
        taskDTO.setId(taskEntity.getId());
        return taskDTO;
    }

    public TaskDTO getTask(String id) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ENTITY NOT FOUND FOR ID"));

        return TaskDTO.builder()
                .id(taskEntity.getId())
                .description(taskEntity.getDescription())
                .startTime(taskEntity.getStartTime())
                .completedTime(taskEntity.getCompletedTime())
                .status(taskEntity.getStatus())
                .build();
    }


    public TaskDTO updateTask(TaskDTO taskDTO) {
        log.info("TaskDTO {}", taskDTO);
//        TaskEntity taskEntity1 = TaskEntity.builder()
//                .id(taskDTO.getId())
//                .status(taskDTO.getStatus())
//                .build();

//        taskEntity1.setStatus(taskDTO.getStatus());
        TaskEntity taskEntity1 = objectMapper.convertValue(taskDTO, TaskEntity.class);
        taskRepository.save(taskEntity1);
        return objectMapper.convertValue(taskEntity1, TaskDTO.class);


    }

}
// new // assign/ re-assign/completed