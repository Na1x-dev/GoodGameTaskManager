package com.example.demo.services.work;

import com.example.demo.models.User;
import com.example.demo.models.Work;

import java.util.List;

public interface WorkService {
    void create(Work work, User user);

    List<Work> readAll(String username);

    Work read(Long id);
}
