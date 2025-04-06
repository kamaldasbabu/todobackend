package com.project.todo.service;

import com.project.todo.dto.TaskUserDTO;
import com.project.todo.dto.TaskUserViewDTO;
import com.project.todo.managers.TaskUserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskUserService {
    @Autowired
    private TaskUserManager taskUserManager;

    public TaskUserViewDTO getTaskByUser(String userId) {
        return taskUserManager.getTaskUsers(userId);
    }

    public TaskUserDTO assignTaskToUser(TaskUserDTO taskUserDTO) {
        return taskUserManager.assignTaskToUser(taskUserDTO);
    }

    public TaskUserDTO reAssignTaskToUser(TaskUserDTO taskUserDTO) {
        return taskUserManager.reAssignTaskToUser(taskUserDTO);
    }

}
