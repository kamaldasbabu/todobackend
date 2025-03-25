package com.project.todo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;
    private  String name;
}
