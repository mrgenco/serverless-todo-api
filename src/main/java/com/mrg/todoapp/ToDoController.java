package com.mrg.todoapp;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    private final ToDoRepository repository;

    @Autowired
    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/todo/all")
    public List<ToDoModel> getAllTodos() {
        Iterable<ToDoModel> todos = this.repository.findAll();
        return Lists.newArrayList(todos);
    }


    @GetMapping("/api/todo/get/{id}")
    public ToDoModel getTodo(@PathVariable Long id) {
        Optional<ToDoModel> todoModel = this.repository.findById(id);
        if (todoModel.isPresent()) {
            return todoModel.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found With Id : " + id);
        }

    }

    @PostMapping("/api/todo/save")
    public ToDoModel saveTodo(@RequestBody ToDoModel todo) {
        return this.repository.save(todo);
    }

    @PostMapping("/api/todo/update")
    public ToDoModel updateTodo(@RequestBody ToDoModel todo) {
        Optional<ToDoModel> todoModel = this.repository.findById(todo.getId());
        if (todoModel.isPresent()) {
            return this.repository.save(todo);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found With Id : " + todo.getId());
        }
    }

    @GetMapping("/api/todo/delete/{id}")
    public void deleteTodo(@PathVariable Long id) {
        Optional<ToDoModel> todoModel = this.repository.findById(id);
        if (todoModel.isPresent()) {
            this.repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found With Id : " + id);
        }

    }
}
