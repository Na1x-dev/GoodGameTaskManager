package com.example.demo.repositories.task;

import com.example.demo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskJpaRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByWorkId(Long id);
}
