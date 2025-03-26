package com.project.todo.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.todo.dto.TaskDTO;
import com.project.todo.dto.TaskUserDTO;
import com.project.todo.dto.TaskUserViewDTO;
import com.project.todo.entities.TaskEntity;
import com.project.todo.entities.TaskUserEntity;
import com.project.todo.entities.UserEntity;
import com.project.todo.repositories.TaskRepository;
import com.project.todo.repositories.TaskUserRepository;
import com.project.todo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class TaskUserManager {
    @Autowired
    private TaskUserRepository taskUserRepository;

    @Autowired
    private  TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public TaskUserViewDTO getTaskUsers(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        List<TaskUserEntity> taskUserEntityList = taskUserRepository.findAllByUserId(userId);
        List<TaskEntity> taskEntityList = taskRepository
                .findAllById(taskUserEntityList.stream().map(TaskUserEntity::getTaskId).toList());

        return TaskUserViewDTO.builder()
                .id(userId)
                .name(userEntity.getName())
                .tasks(taskEntityList
                        .stream()
                        .map(taskEntity -> objectMapper.convertValue(taskEntity, TaskDTO.class))
                        .toList())
                .build();


    }

    public TaskUserDTO assignTaskToUser(TaskUserDTO taskUserDTO) {

        TaskUserEntity taskUserEntity = TaskUserEntity.builder()
                .id(UUID.randomUUID().toString())
                .taskId(taskUserDTO.getTaskId())
                .userId(taskUserDTO.getUserId())
                .date(taskUserDTO.getDate())
                .priority(taskUserDTO.getPriority())
                .status(taskUserDTO.getStatus())
                .isActive("T")
                .build();
log.info("taskUserEntity {}", taskUserEntity);
            taskUserRepository.save(taskUserEntity);
        return  taskUserDTO;
    }

}

