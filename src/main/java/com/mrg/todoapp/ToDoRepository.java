package com.mrg.todoapp;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends DatastoreRepository<ToDoModel, Long> {
}
