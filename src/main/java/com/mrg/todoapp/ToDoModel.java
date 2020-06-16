package com.mrg.todoapp;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name="todos")
public class ToDoModel {

    @Id
    private Long id;
    private String title;
    private String status;

    public ToDoModel(String title, String status) {
        this.title = title;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", status='" + this.status +
                '}';
    }
}
