package com.project.todo.service;

import com.project.todo.dto.TaskDTO;
import com.project.todo.entities.TaskEntity;
import com.project.todo.exceptions.InvalidStatusException;
import com.project.todo.managers.TaskManager;
import com.project.todo.utils.RequestValidatorsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskService {
    @Autowired
    private TaskManager taskManager;
@Autowired
    RequestValidatorsUtil requestValidatorsUtil;
    public List<TaskDTO> getTasks() {
        log.info("get api running333");
        return taskManager.getAllTask();
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {

        requestValidatorsUtil.taskRequestValidator(taskDTO);

        return taskManager.saveTask(taskDTO);
    }

    public TaskDTO getTask(String id) {
        return taskManager.getTask(id);
    }

    public TaskDTO updateTask(TaskDTO taskDTO, String id) {
        log.info("TASK-DTO {} ", taskDTO);
        log.info("ID {} ", id);
        TaskDTO taskDTO1  = taskManager.getTask(id);
//        log.info("taskDTO1 {}", taskDTO1);
        log.info("TASK-DTO-1 {} ", taskDTO1);
        if (taskDTO1.getStatus().equals("completed")) {
            throw new InvalidStatusException(HttpStatus.BAD_REQUEST.value(), "Already completed");
        } else {
            taskDTO1.setStatus(taskDTO.getStatus());
            return taskManager.updateTask(taskDTO1);
        }


    }
}
