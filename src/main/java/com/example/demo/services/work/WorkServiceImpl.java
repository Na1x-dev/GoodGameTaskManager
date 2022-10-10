package com.example.demo.services.work;

import com.example.demo.models.User;
import com.example.demo.models.Work;
import com.example.demo.repositories.work.WorkJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{

    @Autowired
    private WorkJpaRepository workRepository;

    @Override
    public void create(Work work, User user) {
        work.setUser(user);
//        System.out.println(work.toString());
        workRepository.save(work);
    }

    @Override
    public List<Work> readAll(String username) {
        return workRepository.findWorksByUserUsername(username);
    }

    @Override
    public Work read(Long id) {
        return workRepository.findWorkById(id);
    }
}
