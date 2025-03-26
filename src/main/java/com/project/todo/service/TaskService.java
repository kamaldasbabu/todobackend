package com.project.todo.service;
import com.project.todo.dto.TaskDTO;
import com.project.todo.managers.TaskManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class TaskService {
    @Autowired
    private TaskManager taskManager;
    public List<TaskDTO> getTasks() {
        log.info("get api running333");
        return taskManager.getAllTask();
    }

    public TaskDTO saveTask( TaskDTO taskDTO) {
        return  taskManager.saveTask(taskDTO);
    }

    public TaskDTO getTask(String id) {
        return  taskManager.getTask(id);
    }

    public TaskDTO updateTask( TaskDTO taskDTO, String id) {
        return  taskManager.updateTask(taskDTO, id);
    }
}
