package com.project.todo.repositories;

import com.project.todo.entities.TaskUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, String> {
    List<TaskUserEntity> findAllByUserId(String userId);
}
