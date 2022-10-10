package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    Long id;

    @NonNull
    @Column(name = "task_name")
    String taskName;

    @NonNull
    @Column(name = "task_status")
    Boolean taskStatus;

    @ManyToOne
    @JoinColumn(name = "work_id", nullable = false, referencedColumnName = "id")
    Work work;
}
