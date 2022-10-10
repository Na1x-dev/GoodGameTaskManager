package com.example.demo.services.task;

import com.example.demo.models.Task;
import com.example.demo.repositories.task.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskJpaRepository taskRepository;

    @Override
    public List<Task> readAll(Long workId) {
        return taskRepository.findTasksByWorkId(workId);
    }

    @Override
    public void create(Task task) {
        taskRepository.save(task);
    }
}
