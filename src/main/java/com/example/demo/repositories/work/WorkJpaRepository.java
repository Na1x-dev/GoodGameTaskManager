package com.example.demo.repositories.work;

import com.example.demo.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkJpaRepository extends JpaRepository<Work, Long> {

    List<Work> findWorksByUserUsername(String username);
    Work findWorkById(Long id);
}
