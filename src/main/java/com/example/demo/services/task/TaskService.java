package com.example.demo.services.task;

import com.example.demo.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> readAll(Long workId);
    void create(Task task);
}
