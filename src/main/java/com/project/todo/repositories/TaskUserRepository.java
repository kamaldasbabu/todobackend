package com.project.todo.repositories;

import com.project.todo.entities.TaskUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, String> {
}
