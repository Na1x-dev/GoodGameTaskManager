package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "works")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Work {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    Long id;

    @NonNull
    @Column(name = "work_name")
    String workName;

    @NonNull
    @Column(name = "work_description")
    String workDescription;

    @NonNull
    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    User user;

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workName='" + workName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", tasks=" + tasks +
                ", userId=" + user.getId() +
                '}';
    }
}
