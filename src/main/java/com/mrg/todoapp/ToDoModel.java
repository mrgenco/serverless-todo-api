package com.mrg.todoapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name="todos")
@Data
@AllArgsConstructor
public class ToDoModel {
    @Id
    private Long id;
    private String title;
    private String status;
}
