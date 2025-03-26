package com.project.todo.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.todo.dto.TaskDTO;
import com.project.todo.entities.TaskEntity;
import com.project.todo.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TaskDTO> getAllTask() {
        return  taskRepository.findAll().stream().map(taskEntity -> TaskDTO.builder()
                .description(taskEntity.getDescription())
                .startTime(taskEntity.getStartTime())
                .completedTime(taskEntity.getCompletedTime())
                .status(taskEntity.getStatus())
                .build()).toList();
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {

        log.info("TaskDTO {}", taskDTO );
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
        Optional<TaskEntity> taskEntity = taskRepository.findById(id);

        return taskEntity.map(taskEntity1 -> TaskDTO.builder()
                        .description(taskEntity1.getDescription())
                        .startTime(taskEntity1.getStartTime())
                        .completedTime(taskEntity1.getCompletedTime())
                        .status(taskEntity1.getStatus())
                        .build())
                .orElse(null); // Return null or throw an exception if the task is not found
    }


    public TaskDTO updateTask(TaskDTO taskDTO, String id) {

        log.info("TaskDTO {}", taskDTO );

        TaskEntity taskEntity1 = taskRepository.findById(id).orElse(null);

        if(Objects.isNull(taskEntity1)) {
            log.info("ENTITY NOT FOUND FOR ID {}", id);
        } else {
            taskEntity1.setStatus(taskDTO.getStatus());
            taskRepository.save(taskEntity1);
        }
        log.info("taskEntity1 {}", taskEntity1);
        log.info("objectMapper.convertValue(taskEntity1, TaskDTO.class) {}", objectMapper.convertValue(taskEntity1, TaskDTO.class));
        return  objectMapper.convertValue(taskEntity1, TaskDTO.class);
//        return TaskDTO.builder()
//                .id(id)
//                .status(taskDTO.getStatus())
//                .build();


    }

}
